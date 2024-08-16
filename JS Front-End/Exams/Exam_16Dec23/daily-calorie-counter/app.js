function attachEvents() {
    const baseURL = 'http://localhost:3030/jsonstore/tasks/';
    
    const mealsList = document.getElementById('list');
    const foodInput = document.getElementById('food');
    const timeInput = document.getElementById('time');
    const caloriesInput = document.getElementById('calories');
    
    const loadButton = document.getElementById('load-meals');
    const addButton = document.getElementById('add-meal');
    const editButton = document.getElementById('edit-meal');
    
    loadButton.addEventListener('click', loadRecords);
    addButton.addEventListener('click', addMealRecordToDatabase);
    editButton.addEventListener('click', editMealRecordInDatabase);
    
    async function fetchRecords() {
        const response = await fetch(baseURL);
        const result = await response.json();
        
        return result;
    }
    
    async function loadRecords() {
        mealsList.innerHTML = '';
        const result = await fetchRecords();
        
        const meals = Object.values(result);
        
        for (const meal of meals) {
            const currentMealElement = createMealElement(meal);
            
            mealsList.appendChild(currentMealElement);
        }
        
    }
    
    async function addMealRecordToDatabase() {
        const food = foodInput.value;
        const time = timeInput.value;
        const calories = caloriesInput.value;

        const meal = {
            food,
            calories,
            time,
        };

        await fetch(baseURL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(meal),
        });

        clearInputs();

        await loadRecords();

        
    }

    async function editMealRecordInDatabase() {
        const currentId = foodInput.getAttribute('food-id');

        const food = foodInput.value;
        const time = timeInput.value;
        const calories = caloriesInput.value;

        const modifiedMeal = {
            food,
            calories,
            time,
        };

        const url = baseURL + currentId;

        await fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(modifiedMeal),
        });

        await loadRecords();

        editButton.disabled = true;
        addButton.disabled = false;
    }
    
    function createMealElement(meal) {
        // <div class="meal">
        //       <h2>Eggs</h2>
        //       <h3>8:30</h3>
        //       <h3>220</h3>
        //       <div id="meal-buttons">
        //         <button class="change-meal">Change</button>
        //         <button class="delete-meal">Delete</button>
        //       </div>
        // </div>
        const mainDiv = document.createElement('div');
        mainDiv.classList.add('meal');
        
        mainDiv.innerHTML = `
            <h2>${meal.food}</h2>
            <h3>${meal.time}</h3>
            <h3>${meal.calories}</h3>
        `;
        
        const buttonsDiv = document.createElement('div');
        buttonsDiv.classList.add('meal-buttons');
        
        const changeButton = document.createElement('button');
        changeButton.classList.add('change-meal');
        changeButton.textContent = 'Change';
        changeButton.addEventListener('click', () => changeMeal(meal, mainDiv));
        buttonsDiv.appendChild(changeButton);
        
        const deleteButton = document.createElement('button');
        deleteButton.classList.add('delete-meal');
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', () => deleteMealRecordFromDatabase(meal._id));
        buttonsDiv.appendChild(deleteButton);
        
        mainDiv.appendChild(buttonsDiv);
        
        return mainDiv;
    }
    
    function changeMeal(meal, divElement) {
        divElement.remove();
        
        const food = meal.food;
        const time = meal.time;
        const calories = meal.calories;

        foodInput.setAttribute('food-id', meal._id);
        
        foodInput.value = food;
        timeInput.value = time;
        caloriesInput.value = calories;
        
        addButton.disabled = true;
        editButton.disabled = false;
    }
    
    async function deleteMealRecordFromDatabase(id) {
        const url = baseURL + id;
        
        await fetch(url, {
            method: 'DELETE',
        });
        
        await loadRecords();
    }

    function clearInputs() {
        foodInput.value = '';
        timeInput.value = '';
        caloriesInput.value = '';
    }
    
}

attachEvents();
