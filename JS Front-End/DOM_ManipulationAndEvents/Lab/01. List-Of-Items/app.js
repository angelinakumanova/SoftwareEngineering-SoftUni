function addItem() {
    // get elements references
    const inputElement = document.getElementById('newItemText');
    const listElement = document.getElementById('items');

    // create new li element
    const newListItem = document.createElement('li');
    newListItem.textContent = inputElement.value;

    // append new element to list
    listElement.append(newListItem);

    // clear input
    inputElement.value = '';

}
