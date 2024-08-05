function addItem() {
    const menuElement = document.getElementById('menu');
    const newItemTextElement = document.getElementById('newItemText');
    const newItemValueElement = document.getElementById('newItemValue');

    const newOptionElement = document.createElement('option');
    newOptionElement.textContent = newItemTextElement.value;
    newOptionElement.value = newItemValueElement.value;

    menuElement.append(newOptionElement);

    newItemTextElement.value = '';
    newItemValueElement.value = '';
}
