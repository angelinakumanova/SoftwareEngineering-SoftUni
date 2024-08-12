window.addEventListener("load", solve);

function solve() {
    const previewList = document.getElementById('preview-list');
    const expensesList = document.getElementById('expenses-list');
    
    const expenseInput = document.getElementById('expense');
    const amountInput = document.getElementById('amount');
    const dateInput = document.getElementById('date');
    
    const addButton = document.getElementById('add-btn');
    const deleteButton = document.querySelector('.btn.delete');
    
    
    addButton.addEventListener('click', (e) => {
        e.preventDefault();
        
        const expense = expenseInput.value;
        const amount = amountInput.value;
        const date = dateInput.value;
        
        if (!expense || !amount || !date) {
            return;
        }
        
        const listItem = createListItem(expense, amount, date);
        const div = createDivWithButtons(handleEdit, handleOk);
        listItem.appendChild(div);
        addButton.disabled = true;
        
        previewList.appendChild(listItem);
        
        expenseInput.value = '';
        amountInput.value = '';
        dateInput.value  = '';
        
        function handleEdit() {
            expenseInput.value = expense;
            amountInput.value = amount;
            dateInput.value = date;
            
            listItem.remove();
        }
        
        function handleOk() {
            div.remove();
            previewList.removeChild(listItem);
            expensesList.appendChild(listItem);
            
            addButton.disabled = false;
        }
    });

    deleteButton.addEventListener('click', () => {
        location.reload();
    });
    
    
    function createListItem(expense, amount, date) {
        const liElement = document.createElement('li');
        liElement.classList.add('expense-item');
        
        const articleElement = document.createElement('article');
        
        articleElement.innerHTML = `
            <p>Type: ${expense}</p>
            <p>Amount: ${amount}$</p>
            <p>Date: ${date}</p>
        `;
        
        liElement.appendChild(articleElement);
        
        return liElement;
    }
    
    function createDivWithButtons(handleEdit, handleOk) {
        const divElement = document.createElement('div');
        divElement.classList.add('buttons');
        
        const editButton = document.createElement('button');
        editButton.classList.add('btn', 'edit');
        editButton.textContent = 'edit';
        editButton.addEventListener('click', handleEdit);
        
        const okButton = document.createElement('button');
        okButton.classList.add('btn', 'ok');
        okButton.textContent = 'ok';
        okButton.addEventListener('click', handleOk);
        
        divElement.appendChild(editButton);
        divElement.appendChild(okButton);
        
        return divElement;
    }
}
