function attachEvents() {
    let globalCurrentRecord = {};

    const baseURL = 'http://localhost:3030/jsonstore/records/';
    
    const recordsList = document.getElementById('list');
    const loadRecordsButton = document.getElementById('load-records');
    const addRecordButton = document.getElementById('add-record');
    const editRecordButton = document.getElementById('edit-record');
    
    const nameInput = document.getElementById('p-name');
    const stepsInput = document.getElementById('steps');
    const caloriesInput = document.getElementById('calories');
    
    loadRecordsButton.addEventListener('click', loadRecords);
    
    addRecordButton.addEventListener('click', async () => {
        const name = nameInput.value;
        const steps = stepsInput.value;
        const calories = caloriesInput.value;
        
        if (!name || !steps || !calories) {
            return;
        }
        
        const record = {
            name,
            steps,
            calories,
        };
        
        await addRecord(record);
        
        nameInput.value = '';
        stepsInput.value = '';
        caloriesInput.value = '';

        await loadRecords();
    });

    editRecordButton.addEventListener('click', editRecord);
    
    async function fetchRecords() {
        const response = await fetch(baseURL);
        const result = await response.json();
        
        return result;
    }

    async function loadRecords() {
        recordsList.innerHTML = '';
        const result = await fetchRecords();
        const records = Object.values(result);
        console.log(result);
        
        for (const record of records) {
            const currentRecord = createLiElement(record);
            
            recordsList.appendChild(currentRecord);
        }
        
    }
    
    async function addRecord(data) {
        await fetch(baseURL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });
    }


    
    function createLiElement(record) {
        /*<li class="record">
        <div class="info">
        <p>Martin</p>
        <p>11000</p>
        <p>600</p>
        </div>
        <div class="btn-wrapper">
        <button class="change-btn">Change</button>
        <button class="delete-btn">Delete</button>
        </div>
        </li>
        */
        
        //{name: 'Mario', steps: '9875', calories: '344'
        const liElement = document.createElement('li');
        liElement.classList.add('record');
        
        const divInfo = document.createElement('div');
        divInfo.classList.add('info');
        
        divInfo.innerHTML = `
            <p>${record.name}</p>
            <p>${record.steps}</p>
            <p>${record.calories}</p>
        `;
        
        liElement.appendChild(divInfo);
        
        const divButtons = document.createElement('div');
        divButtons.classList.add('btn-wrapper');
        
        const changeButton = document.createElement('button');
        changeButton.classList.add('change-btn');
        changeButton.textContent = 'Change';
        changeButton.addEventListener('click', changeRecord);
        divButtons.appendChild(changeButton);
        
        const deleteButton = document.createElement('button');
        deleteButton.classList.add('delete-btn');
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', deleteRecord);
        divButtons.appendChild(deleteButton);
        
        liElement.appendChild(divButtons);
        
        return liElement;
    }
    
    function changeRecord(e) {
        const record = e.target.closest('li.record');
        
        const paragraphs = record.querySelectorAll('p');
        const name = paragraphs[0].textContent;
        const steps = paragraphs[1].textContent;
        const calories = paragraphs[2].textContent;
        
        nameInput.value = name;
        stepsInput.value = steps;
        caloriesInput.value = calories;
        
        addRecordButton.disabled = true;
        editRecordButton.disabled = false;

        globalCurrentRecord = {
            name,
            steps, 
            calories
        };
    }
    
    async function deleteRecord(e) {
        const result = await fetchRecords();
        const records = Object.values(result);
        const record = e.target.closest('li.record');

        const paragraphs = record.querySelectorAll('p');
        const name = paragraphs[0].textContent;
        const steps = paragraphs[1].textContent;
        const calories = paragraphs[2].textContent;

        const foundRecord = records.find(r => r.name === name && r.steps === steps && r.calories === calories);

        if(foundRecord) {
            const url = baseURL + foundRecord._id;

            await fetch(url, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            });
        }

        await loadRecords();
    }
    
    async function editRecord() {
        const result = await fetchRecords();
        const records = Object.values(result);

        const record = globalCurrentRecord;

        const foundRecord = records.find(r => r.name === record.name && r.steps === record.steps && r.calories === record.calories);
        console.log(foundRecord);
        
        const newName = nameInput.value;
        const newSteps = stepsInput.value;
        const newCalories = caloriesInput.value;

        if (foundRecord) {
            const url = baseURL + foundRecord._id;

            const newRecord = {
                name: newName,
                steps: newSteps,
                calories: newCalories,
                _id: foundRecord.id_,
            };

            await fetch(url, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newRecord),
            });

            await loadRecords();

            addRecordButton.disabled = false;
            editRecordButton.disabled = true;

            nameInput.value = '';
            stepsInput.value = '';
            caloriesInput.value = '';
        }

    
    }
    
    
}

attachEvents();
