function attachEvents() {
    const baseURL = 'http://localhost:3030/jsonstore/gifts/';

    const giftList = document.getElementById('gift-list');

    const giftInput = document.getElementById('gift');
    const receiverInput = document.getElementById('for');
    const priceInput = document.getElementById('price');

    const addButton = document.getElementById('add-present');
    const editButton = document.getElementById('edit-present');
    const loadButton = document.getElementById('load-presents');

    loadButton.addEventListener('click', loadRecords);
    addButton.addEventListener('click', addPresentToDatabase);
    editButton.addEventListener('click', editPresentInDatabase);



    async function fetchRecords() {
        const response = await fetch(baseURL);
        const result = await response.json();
        
        return result;
    }
    
    async function loadRecords() {
        giftList.innerHTML = '';
        const result = await fetchRecords();
        
        const presents = Object.values(result);
        
        for (const present of presents) {
            const currentPresentElement = createPresentDivElement(present);
            
            giftList.appendChild(currentPresentElement);
        }
        
    }

    async function addPresentToDatabase() {
        const gift = giftInput.value;
        const receiver = receiverInput.value;
        const price = priceInput.value;

        const present = {
            gift,
            for: receiver,
            price,
        };

        await fetch(baseURL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(present),
        });

        clearInputs();

        await loadRecords();

        
    }

    async function editPresentInDatabase() {
        const id = giftInput.getAttribute('present-id');

        const gift = giftInput.value;
        const receiver = receiverInput.value;
        const price = priceInput.value;

        const modifiedPresent = {
            gift,
            for: receiver,
            price,
        };

        const url = baseURL + id;

        await fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(modifiedPresent),
        });

        await loadRecords();

        addButton.disabled = false;
        editButton.disabled = true;
        
        clearInputs();
    }

    function createPresentDivElement(present) {
        // <div class="gift-sock">
        //       <div class="content">
        //         <p>PS 5</p>
        //         <p>Martin</p>
        //         <p>899</p>
        //       </div>
        //       <div class="buttons-container">
        //         <button class="change-btn">Change</button>
        //         <button class="delete-btn">Delete</button>
        //       </div>
        // </div>

        const mainDiv = document.createElement('div');
        mainDiv.classList.add('gift-sock');

        const contentDiv = document.createElement('div');
        contentDiv.classList.add('content');
        contentDiv.innerHTML = `
            <p>${present.gift}</p>
            <p>${present.for}</p>
            <p>${present.price}</p>
        `;

        mainDiv.appendChild(contentDiv);

        const buttonsDiv = document.createElement('div');
        buttonsDiv.classList.add('buttons-container');

        const changeButton = document.createElement('button');
        changeButton.classList.add('change-btn');
        changeButton.textContent = 'Change';
        changeButton.addEventListener('click', () => changePresent(present));
        buttonsDiv.appendChild(changeButton);

        const deleteButton = document.createElement('button');
        deleteButton.classList.add('delete-btn');
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', () => deletePresentFromDatabase(present._id));
        buttonsDiv.appendChild(deleteButton);

        mainDiv.appendChild(buttonsDiv);

        return mainDiv;
    }

    function changePresent(present) {
        const currentGift = present.gift;
        const currentReceiver = present.for;
        const currentPrice = present.price;
        
        
        giftInput.value = currentGift;
        receiverInput.value = currentReceiver;
        priceInput.value = currentPrice;
        
        addButton.disabled = true;
        editButton.disabled = false;
        
        giftInput.setAttribute('present-id', present._id);
        
    }

    async function deletePresentFromDatabase(id) {
        const url = baseURL + id;

        await fetch(url, {
            method: 'DELETE',
        });

        await loadRecords();
    }

    function clearInputs() {
        giftInput.value = '';
        receiverInput.value = '';
        priceInput.value = '';
    }
}

attachEvents();
