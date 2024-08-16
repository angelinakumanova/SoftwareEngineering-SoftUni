function attachEvents() {
    const baseURL = 'http://localhost:3030/jsonstore/games/';
    
    const gamesList = document.getElementById('games-list');
    const nameInput = document.getElementById('g-name');
    const typeInput = document.getElementById('type');
    const playersInput = document.getElementById('players');
    
    const loadGamesButton = document.getElementById('load-games');
    const addButton = document.getElementById('add-game');
    const editButton = document.getElementById('edit-game');
    
    
    loadGamesButton.addEventListener('click', loadGames);
    addButton.addEventListener('click', addGame);
    editButton.addEventListener('click', editGame);
    
    
    async function fetchGames() {
        const response = await fetch(baseURL);
        const result = await response.json();
        
        return result;
    }
    
    async function loadGames() {
        gamesList.innerHTML = '';
        const result = await fetchGames();
        
        const games = Object.values(result);
        
        for (const game of games) {
            const currentGame = createGameDivElement(game);
            
            gamesList.appendChild(currentGame);
        }
        
    }
    
    async function addGame() {
        const name = nameInput.value;
        const type = typeInput.value;
        const players = playersInput.value;
        
        const game = {
            name,
            type,
            players,
        };
        
        await fetch(baseURL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(game)
        });
        
        clearInputs();
        await loadGames();
    }
    
    async function editGame() {
        const name = nameInput.value;
        const type = typeInput.value;
        const players = playersInput.value;
        
        const currentId = nameInput.getAttribute('game-id');
        
        
        const modifiedGame = {
            name,
            type,
            players,
            _id: currentId,
        };
        
        const url = baseURL + currentId;
        
        await fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(modifiedGame),
        });
        
        
        await loadGames();

        addButton.disabled = false;
        editButton.disabled = true;
        
        clearInputs();
        
    }
    
    function createGameDivElement(game) {
        // <div class="board-game">
        //       <div class="content">
        //         <p>CATAN-Rise of Inkas</p>
        //         <p>Eurogame</p>
        //         <p>4</p>
        //       </div>
        //       <div class="buttons-container">
        //         <button class="change-btn">Change</button>
        //         <button class="delete-btn">Delete</button>
        //       </div>
        //     </div>
        
        //name, type, players
        const boardGame = document.createElement('div');
        boardGame.classList.add('board-game');
        
        const contentDiv = document.createElement('div');
        contentDiv.classList.add('content');
        contentDiv.innerHTML = `
            <p>${game.name}</p>
            <p>${game.type}</p>
            <p>${game.players}</p>
        `;
        
        boardGame.appendChild(contentDiv);
        
        const buttonsDiv = document.createElement('div');
        buttonsDiv.classList.add('buttons-container');
        
        const changeButton = document.createElement('button');
        changeButton.classList.add('change-btn');
        changeButton.textContent = 'Change';
        changeButton.addEventListener('click', () => changeGame(game.name, game.type, game.players, game._id));
        buttonsDiv.appendChild(changeButton);
        
        const deleteButton = document.createElement('button');
        deleteButton.classList.add('delete-btn');
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', async () => {
            const url = baseURL + game._id;
            
            await fetch(url, {
                method: 'DELETE',
            });
            
            await loadGames();
        });
        buttonsDiv.appendChild(deleteButton);
        
        boardGame.appendChild(buttonsDiv);
        
        return boardGame;
    }
    
    function changeGame(name, type, players, gameId) {
        const currentName = name;
        const currentType = type;
        const currentPlayers = players;
        
        
        nameInput.value = currentName;
        typeInput.value = currentType;
        playersInput.value = currentPlayers;
        
        addButton.disabled = true;
        editButton.disabled = false;
        
        nameInput.setAttribute('game-id', gameId);
        
    }
    
    function clearInputs() {
        nameInput.value = '';
        typeInput.value = '';
        playersInput.value = '';
    }
    
    
}

attachEvents();
