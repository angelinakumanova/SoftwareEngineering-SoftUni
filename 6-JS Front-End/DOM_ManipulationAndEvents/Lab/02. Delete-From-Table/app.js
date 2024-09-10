function deleteByEmail() {
    const trElements = document.querySelectorAll('tbody tr');
    const inputElement = document.querySelector('input[type]');
    const resultElement = document.getElementById('result');

    const searchedEmail = inputElement.value;

    for (const trElement of trElements) {
        const currentEmail = trElement.querySelector('td:nth-child(2)').textContent;
        
        if (currentEmail === searchedEmail) {
            trElement.remove();
            resultElement.textContent = 'Deleted.';
            break;
        } else {
            resultElement.textContent = 'Not found.';
        }
    }

    inputElement.value = '';
}
