window.addEventListener("load", solve);

function solve() {
    const reviewList = document.getElementById('review-list');
    const publishedList = document.getElementById('published-list');
    
    const titleInput = document.getElementById('task-title');
    const categoryInput = document.getElementById('task-category');
    const contentTextArea = document.getElementById('task-content');
    
    const publishButton = document.getElementById('publish-btn');
    
    publishButton.addEventListener('click', () => {
        
        const title = titleInput.value;
        const category = categoryInput.value;
        const content = contentTextArea.value;
        
        if (!title || !category || !content) {
            return;
        }
        
        const liElement = createLiElement(title, category, content, handleEdit, handlePost);
        
        reviewList.appendChild(liElement);
        
        titleInput.value = '';
        categoryInput.value = '';
        contentTextArea.value = '';
        
        function handleEdit() {
            titleInput.value = title;
            categoryInput.value = category;
            contentTextArea.value = content;

            reviewList.removeChild(liElement);
        }

        function handlePost() {
            const editButton = liElement.querySelector('button.edit');
            const postButton = liElement.querySelector('button.post');

            editButton.remove();
            postButton.remove();

            reviewList.removeChild(liElement);
            publishedList.appendChild(liElement);
        }
    });
    
    
    function createLiElement(title, category, content, handleEdit, handlePost) {
        const liElement = document.createElement('li');
        liElement.classList.add('rpost');
        
        const articleElement = document.createElement('article');
        
        articleElement.innerHTML = `
            <h4>${title}</h4>
            <p>Category: ${category}</p>
            <p>Content: ${content}</p>
        `;
        
        liElement.appendChild(articleElement);
        
        const editButton = createButton('Edit', handleEdit, 'action-btn', 'edit');
        const postButton = createButton('Post', handlePost, 'action-btn', 'post');
        
        liElement.appendChild(editButton);
        liElement.appendChild(postButton);
        
        return liElement;
    }
    
    function createButton(text, func, ...classNames) {
        const button = document.createElement('button');
        button.classList.add(...classNames);
        button.textContent = text;
        button.addEventListener('click', func);
        
        return button;
    }
}
