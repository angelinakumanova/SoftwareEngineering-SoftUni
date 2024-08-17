function attachEvents() {
    const baseURL = 'http://localhost:3030/jsonstore/tasks/';

    const loadButton = document.getElementById('load-board-btn');
    const addButton = document.getElementById('create-task-btn');

    const toDoList = document.querySelector('#todo-section > ul.task-list');
    const inProgressList = document.querySelector('#in-progress-section > ul.task-list');
    const codeReviewList = document.querySelector('#code-review-section > ul.task-list');
    const doneList = document.querySelector('#done-section > ul.task-list');

    const titleInput = document.getElementById('title');
    const descriptionElement = document.getElementById('description');

    loadButton.addEventListener('click', loadRecords);
    addButton.addEventListener('click', addRecordToDatabase);

    //title, description, status
    async function fetchRecords() {
        const response = await fetch(baseURL);
        const result = await response.json();

        return result;
    }

    async function loadRecords() {
        clearLists();
        const result = await fetchRecords();
        const records = Object.values(result);
        
        for(const record of records) {
            addRecordToDesiredList(record);
        }
        
    }

    async function addRecordToDatabase() {
        const title = titleInput.value;
        const description = descriptionElement.value;

        if (!title || !description) {
            return;
        }

        const record = {
            title,
            description,
            status: 'ToDo',
        };

        await fetch(baseURL, {
            method:'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(record),
        });

        addRecordToDesiredList(record);
        clearInputs();

        await loadRecords();
    }

    function addRecordToDesiredList(record) {
        const recordElement = createLiElement(record);
        const list = getList(record.status);

        list.appendChild(recordElement);
    }
    //<li class="task">
    //   <h3>Fix Bug</h3>
    //   <p>We have a new bug to fix</p>
    //   <button>Move to In Progress/Move to Code Review/Move to Done/Close</button>
    // </li>

    function createLiElement(record) {
        const title = record.title;
        const description = record.description;
        const status = record.status;

        const liElement = document.createElement('li');
        liElement.classList.add('task');
        
        liElement.innerHTML = `<h3>${title}</h3><p>${description}</p>`;

        const button = document.createElement('button');
        button.textContent = getButtonText(status);
        button.addEventListener('click', () => moveTask(record, liElement));
        liElement.appendChild(button);

        return liElement;
    }

    async function moveTask(record, recordElement) {
        const currentStatus = record.status;

        if (currentStatus === 'Done') {
            await deleteRecord(record._id);
            return;
        }

        const newStatus = getNextStatus(currentStatus);
        record.status = newStatus;

        const url = baseURL + record._id;
        await fetch(url, {
            method:'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ status: newStatus }),
        });
        
    
        recordElement.remove();
    
        addRecordToDesiredList(record);
    }

    async function deleteRecord(id) {
        const url = baseURL + id;

        await fetch(url, {
            method: 'DELETE',
        });

        await loadRecords();
    }

    function getButtonText(status) {
        switch(status) {
            case 'ToDo':
                return 'Move to In Progress';
            case 'In Progress':
                return 'Move to Code Review';
            case 'Code Review':
                return 'Move to Done';
            case 'Done':
                return 'Close';
        }

    }

    function getNextStatus(currentStatus) {
        switch (currentStatus) {
            case 'ToDo': return 'In Progress';
            case 'In Progress': return 'Code Review';
            case 'Code Review': return 'Done';
        }
    }

    function getList(status) {
        switch (status) {
            case 'ToDo': return toDoList;
            case 'In Progress': return inProgressList;
            case 'Code Review': return codeReviewList;
            case 'Done': return doneList;
        }
    }

    function clearLists() {
        toDoList.innerHTML = '';
        inProgressList.innerHTML = '';
        codeReviewList.innerHTML = '';
        doneList.innerHTML = '';
    }

    function clearInputs() {
        titleInput.value = '';
        descriptionElement.value = '';
    }

}

attachEvents();