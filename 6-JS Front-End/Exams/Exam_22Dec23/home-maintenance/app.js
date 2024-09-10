window.addEventListener("load", solve);

function solve() {
    const taskList = document.getElementById('task-list');
    const doneList = document.getElementById('done-list');
    
    const placeInput = document.getElementById('place');
    const actionInput = document.getElementById('action');
    const personInput = document.getElementById('person');
    
    const addButton = document.getElementById('add-btn');
    
    addButton.addEventListener('click', (e) => {
        e.preventDefault();
        
        const place = placeInput.value;
        const action = actionInput.value;
        const person = personInput.value;
        
        if (!place || !action || !person) {
            return;
        }
        
        const listItem = createListItem(place, action, person);
        const div = createDivWithButtons(handleEdit, handleDone);
        
        listItem.appendChild(div);
        
        taskList.appendChild(listItem);
        
        
        placeInput.value = '';
        actionInput.value = '';
        personInput.value = '';
        
        
        function handleEdit() {
            placeInput.value = place;
            actionInput.value = action;
            personInput.value = person;
            
            listItem.remove();
        }
        
        function handleDone() {
            const divElement = listItem.querySelector('div.buttons');
            divElement.remove();
            
            const deleteButton = createButton('Delete', 'delete', () => {
                doneList.removeChild(listItem);
            });
            
            listItem.appendChild(deleteButton);
            
            taskList.removeChild(listItem);
            
            doneList.appendChild(listItem);
        }
    });
    
    
    
    function createListItem(place, action, person) {
        const liElement = document.createElement('li');
        liElement.classList.add('clean-task');
        const articleElement = document.createElement('article');
        
        articleElement.innerHTML = `
            <p>Place:${place}</p>
            <p>Action:${action}</p>
            <p>Person:${person}</p>
        `;
        
        liElement.appendChild(articleElement);
        
        return liElement;
    }
    
    function createDivWithButtons(handleEdit, handleDone) {
        const divElement = document.createElement('div');
        divElement.classList.add('buttons');
        
        const editButton = createButton('Edit', 'edit', handleEdit);
        const doneButton = createButton('Done', 'done', handleDone);
        
        divElement.appendChild(editButton);
        divElement.appendChild(doneButton);
        
        return divElement;
    }
    
    function createButton(text, className, func) {
        const button = document.createElement('button');
        button.textContent = text;
        button.classList.add(className);
        button.addEventListener('click', func);
        
        return button;
    }
}




