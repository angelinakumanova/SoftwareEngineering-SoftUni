function attachEvents() {
    const baseURL = 'http://localhost:3030/jsonstore/matches/';
    
    const matchList = document.getElementById('list');
    
    const hostInput = document.getElementById('host');
    const finalScoreInput = document.getElementById('score');
    const guestInput = document.getElementById('guest');
    
    const loadMatches = document.getElementById('load-matches');
    const addButton = document.getElementById('add-match');
    const editButton = document.getElementById('edit-match');
    
    loadMatches.addEventListener('click', loadRecords);
    addButton.addEventListener('click', addMatch);
    editButton.addEventListener('click', editMatch);
    
    async function fetchRecords() {
        const response = await fetch(baseURL);
        const result = await response.json();
        
        return result;
    }
    
    async function loadRecords() {
        const result = await fetchRecords();
        const matches = Object.values(result);
        
        matches.forEach(match => matchList.appendChild(createLiElement(match)));
    }

    async function addMatch() {
        const host = hostInput.value;
        const score = finalScoreInput.value;
        const guest = guestInput.value;

        const match = {
            host,
            score,
            guest,
        };

        await fetch(baseURL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(match),
        });

        clearInputs();

        await loadRecords();

    }
    
    async function editMatch() {
        const host = hostInput.value;
        const score = finalScoreInput.value;
        const guest = guestInput.value;
        
        const modifiedMatch = {
            host,
            score,
            guest,
        };
        
        const currentId = hostInput.getAttribute('match-id');
        const url = baseURL + currentId;
        
        await fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(modifiedMatch),
        });
        
        clearInputs();

        addButton.disabled = false;
        editButton.disabled = true;

        await loadRecords();
    }
    
    function createLiElement(match) {
        // <li class="match">
        //       <div class="info">
        //         <p>England</p>
        //         <p>2-1</p>
        //         <p>Slovakia</p>
        //       </div>
        //       <div class="btn-wrapper">
        //         <button class="change-btn">Change</button>
        //         <button class="delete-btn">Delete</button>
        //       </div>
        // </li>
        
        const liElement = document.createElement('li');
        liElement.classList.add('match');
        
        
        const infoDiv = document.createElement('div');
        infoDiv.classList.add('info');
        
        infoDiv.innerHTML = `
            <p>${match.host}</p>
            <p>${match.score}</p>
            <p>${match.guest}</p>
        `;
        
        liElement.appendChild(infoDiv);
        
        const buttonsDiv = document.createElement('div');
        buttonsDiv.classList.add('btn-wrapper');
        
        const changeButton = document.createElement('button');
        changeButton.classList.add('change-btn');
        changeButton.textContent = 'Change';
        changeButton.addEventListener('click', () => changeMatch(match));
        buttonsDiv.appendChild(changeButton);
        
        const deleteButton = document.createElement('button');
        deleteButton.classList.add('delete-btn');
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', () => deleteMatch(match._id));
        buttonsDiv.appendChild(deleteButton);

        liElement.appendChild(buttonsDiv);

        return liElement;
    }
    
    
    function changeMatch(match) {
        hostInput.value = match.host;
        finalScoreInput.value = match.score;
        guestInput.value = match.guest;
        
        hostInput.setAttribute('match-id', match._id);
        
        addButton.disabled = true;
        editButton.disabled = false;
    }
    
    async function deleteMatch(id) {
        const url = baseURL + id;
        
        await fetch(url, {
            method: 'DELETE',
        });
        
        await loadRecords();
    }

    function clearInputs() {
        hostInput.value = '';
        finalScoreInput.value = '';
        guestInput.value = '';
    }
    
}

attachEvents();
