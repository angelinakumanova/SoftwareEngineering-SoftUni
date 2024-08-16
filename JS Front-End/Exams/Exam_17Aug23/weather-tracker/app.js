function attachEvents() {
    const baseURL = 'http://localhost:3030/jsonstore/tasks/';
    
    const weatherList = document.getElementById('list');
    const locationInput = document.getElementById('location');
    const temperatureInput = document.getElementById('temperature');
    const dateInput = document.getElementById('date');
    
    const loadButton = document.getElementById('load-history');
    const addButton = document.getElementById('add-weather');
    const editButton = document.getElementById('edit-weather');
    
    loadButton.addEventListener('click', loadRecords);
    addButton.addEventListener('click', addForecastToDatabase);
    editButton.addEventListener('click', editForecastInDatabase);
    
    async function fetchRecords() {
        const response = await fetch(baseURL);
        const result = await response.json();
        
        return result;
    }
    
    async function loadRecords() {
        weatherList.innerHTML = '';
        const result = await fetchRecords();
        
        const forecasts = Object.values(result);
        
        for (const forecast of forecasts) {
            const currentForecastElement = createForecastElement(forecast);
            
            weatherList.appendChild(currentForecastElement);
        }
        
    }
    
    async function addForecastToDatabase() {
        const location = locationInput.value;
        const temperature = temperatureInput.value;
        const date = dateInput.value;
        
        const forecast = {
            location,
            temperature,
            date,
        };
        
        await fetch(baseURL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(forecast),
        });
        
        clearInputs();
        
        await loadRecords();
        
        
    }
    
    async function editForecastInDatabase() {
        const currentId = locationInput.getAttribute('forecast-id');
        
        const location = locationInput.value;
        const temperature = temperatureInput.value;
        const date = dateInput.value;
        
        const modifiedForecast = {
            location,
            temperature,
            date,
            currentId,
        };
        
        const url = baseURL + currentId;
        
        await fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(modifiedForecast),
        });
        
        await loadRecords();
        
        editButton.disabled = true;
        addButton.disabled = false;
    }
    
    function createForecastElement(forecast) {
        // <div class="container">
        //     <h2>Sofia</h2>
        //     <h3>2023-08-01</h3>
        //     <h3 id="celsius">35</h3>
        //     <div id="buttons-container">  
        //     <button class="change-btn">Change</button>
        //     <button class="delete-btn">Delete</button>
        //     </div>
        
        // </div>
        const mainDiv = document.createElement('div');
        mainDiv.classList.add('container');
        
        mainDiv.innerHTML = `
            <h2>${forecast.location}</h2>
            <h3>${forecast.date}</h3>
            <h3>${forecast.temperature}</h3>
        `;
        
        const buttonsDiv = document.createElement('div');
        buttonsDiv.classList.add('buttons-container');
        
        const changeButton = document.createElement('button');
        changeButton.classList.add('change-btn');
        changeButton.textContent = 'Change';
        changeButton.addEventListener('click', () => changeForecast(forecast, mainDiv));
        buttonsDiv.appendChild(changeButton);
        
        const deleteButton = document.createElement('button');
        deleteButton.classList.add('delete-btn');
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', () => deleteForecastFromDatabase(forecast._id));
        buttonsDiv.appendChild(deleteButton);
        
        mainDiv.appendChild(buttonsDiv);
        
        return mainDiv;
    }
    
    function changeForecast(forecast, divElement) {
        divElement.remove();
        
        const location = forecast.location;
        const date = forecast.date;
        const temperature = forecast.temperature;
        
        locationInput.setAttribute('forecast-id', forecast._id);
        
        locationInput.value = location;
        dateInput.value = date;
        temperatureInput.value = temperature;
        
        addButton.disabled = true;
        editButton.disabled = false;
    }
    
    async function deleteForecastFromDatabase(id) {
        const url = baseURL + id;
        
        await fetch(url, {
            method: 'DELETE',
        });
        
        await loadRecords();
    }
    
    function clearInputs() {
        locationInput.value = '';
        temperatureInput.value = '';
        dateInput.value = '';
    }
    
}

attachEvents();
