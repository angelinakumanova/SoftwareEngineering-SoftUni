function attachEvents() {
    const baseURL = 'http://localhost:3030/jsonstore/tasks/';
    
    
    const titleInput = document.getElementById('title');
    const loadButton = document.getElementById('load-button');
    const addButton = document.getElementById('add-button');
    const toDoList = document.getElementById('todo-list');
    
    addButton.addEventListener('click', (e) => {
        e.preventDefault()
        addTask();
    });
    loadButton.addEventListener('click',(e) => {
        e.preventDefault();
        loadRecords();
    });
    
    
    async function fetchRecords() {
        const response = await fetch(baseURL);
        const result = await response.json();
        
        return result;
    }
    
    async function loadRecords() {
        toDoList.innerHTML = '';
        const result = await fetchRecords();
        const tasks = Object.values(result);
        
        tasks.forEach(task => toDoList.appendChild(createTaskElement(task)));
    }
    
    async function addTask() {
        const name = titleInput.value;
        
        await fetch(baseURL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({name: name}),
        }).catch(err => console.log(err)
    );
    
    titleInput.value = '';
    
    await loadRecords();
}

function createTaskElement(task) {
    const liElement = document.createElement('li');
    
    const nameElement = document.createElement('span');
    nameElement.textContent = task.name;
    liElement.appendChild(nameElement);
    
    const removeButton = document.createElement('button');
    removeButton.textContent = 'Remove';
    removeButton.addEventListener('click', async () => {
        const url = baseURL + task._id;
        await fetch(url, {
            method: 'DELETE',
        });
        
        liElement.remove();
        
        await loadRecords();
    });
    liElement.appendChild(removeButton);
    
    const editButton = document.createElement('button');
    editButton.textContent = 'Edit';
    editButton.addEventListener('click', () => {
        nameElement.remove();
        
        const nameInput = document.createElement('input');
        nameInput.value = task.name;
        liElement.insertBefore(nameInput, liElement.firstChild);
        editButton.remove();
        
        const submitButton = document.createElement('button');
        submitButton.textContent = 'Submit';
        submitButton.addEventListener('click', () => submitTask(nameInput, task._id));
        liElement.appendChild(submitButton);
    });
    liElement.appendChild(editButton);
    
    return liElement;
}


async function submitTask(nameInput, id) {
    const newName = nameInput.value;
    
    const url = baseURL + id;
    await fetch(url, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({name: newName}),
    });
    
    await loadRecords();
}
}

attachEvents();
