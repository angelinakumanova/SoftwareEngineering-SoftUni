function attachEvents() {
    const baseURL = 'http://localhost:3030/jsonstore/tasks/';
    
    const vacationsList = document.getElementById('list');
    const nameInput = document.getElementById('name');
    const daysInput = document.getElementById('num-days');
    const dateInput = document.getElementById('from-date');
    
    const loadButton = document.getElementById('load-vacations');
    const addButton = document.getElementById('add-vacation');
    const editButton = document.getElementById('edit-vacation');
    
    loadButton.addEventListener('click', loadRecords);
    addButton.addEventListener('click', addVacationToDatabase);
    editButton.addEventListener('click', editVacationInDatabase);
    
    async function fetchRecords() {
        const response = await fetch(baseURL);
        const result = await response.json();
        
        return result;
    }
    
    async function loadRecords() {
        vacationsList.innerHTML = '';
        const result = await fetchRecords();
        const vacations = Object.values(result);
        
        const vacationElements = vacations.map(vacation => createVacationElement(vacation));
        vacationElements.forEach(v => vacationsList.appendChild(v));
    }
    
    async function addVacationToDatabase() {
        const name = nameInput.value;
        const days = daysInput.value;
        const date = dateInput.value;
        
        const vacation = {
            name,
            days,
            date,
        };
        
        await fetch(baseURL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(vacation),
        });
        
        clearInputs();
        
        await loadRecords();
        
        
    }
    
    async function editVacationInDatabase() {
        const currentId = nameInput.getAttribute('vacation-id');
        
        const name = nameInput.value;
        const date = dateInput.value;
        const days = daysInput.value;
        
        const modifiedVacation = {
            name,
            days,
            date,
            currentId,
        };
        
        const url = baseURL + currentId;
        
        await fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(modifiedVacation),
        });
        
        await loadRecords();
        
        editButton.disabled = true;
        addButton.disabled = false;
    }
    
    function createVacationElement(vacation) {
        // <div class="container">
        //     <h2>Carren Davis</h2>
        //     <h3>2023-06-09</h3>
        //     <h3>5</h3>
        //     <button class="change-btn">Change</button>
        //     <button class="done-btn">Done</button>
        // </div>

        const mainDiv = document.createElement('div');
        mainDiv.classList.add('container');
        
        mainDiv.innerHTML = `
            <h2>${vacation.name}</h2>
            <h3>${vacation.date}</h3>
            <h3>${vacation.days}</h3>
        `;
        
        const changeButton = document.createElement('button');
        changeButton.classList.add('change-btn');
        changeButton.textContent = 'Change';
        changeButton.addEventListener('click', () => changeVacation(vacation, mainDiv));
        mainDiv.appendChild(changeButton);
        
        const deleteButton = document.createElement('button');
        deleteButton.classList.add('done-btn');
        deleteButton.textContent = 'Done';
        deleteButton.addEventListener('click', () => deleteVacationFromDatabase(vacation._id));
        mainDiv.appendChild(deleteButton);

        
        return mainDiv;
    }
    
    function changeVacation(vacation, divElement) {
        divElement.remove();
        
        const name = vacation.name;
        const date = vacation.date;
        const days = vacation.days;
        
        nameInput.setAttribute('vacation-id', vacation._id);
        
        nameInput.value = name;
        dateInput.value = date;
        daysInput.value = days;
        
        addButton.disabled = true;
        editButton.disabled = false;
    }
    
    async function deleteVacationFromDatabase(id) {
        const url = baseURL + id;
        
        await fetch(url, {
            method: 'DELETE',
        });
        
        await loadRecords();
    }
    
    function clearInputs() {
        nameInput.value = '';
        dateInput.value = '';
        daysInput.value = '';
    }
    
}

attachEvents();
