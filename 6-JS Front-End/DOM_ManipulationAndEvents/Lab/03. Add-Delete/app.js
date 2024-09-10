function addItem() {
    const listElement = document.getElementById('items');
    const inputElement = document.getElementById('newItemText');



    const newListItem = document.createElement('li');
    newListItem.textContent = inputElement.value;

    const deleteButton = document.createElement('a');
    deleteButton.textContent = '[Delete]';
    deleteButton.href = '#';

    deleteButton.addEventListener('click', (e) => {
        e.currentTarget.parentElement.remove();
    });

    newListItem.append(deleteButton);

    listElement.append(newListItem);

    inputElement.value = '';
}
