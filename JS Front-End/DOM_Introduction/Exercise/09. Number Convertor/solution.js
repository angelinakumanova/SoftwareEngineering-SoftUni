function solve() {
    const inputElement = document.getElementById('input');
    const selectElement = document.getElementById('selectMenuTo');
    const resultElement = document.getElementById('result');
    const convertButton = document.querySelector('button');

    const binaryOptionElement = selectElement.querySelector('option');
    binaryOptionElement.value = 'binary';
    binaryOptionElement.textContent = 'Binary';

    const hexadecimalOptionElement = document.createElement('option');
    hexadecimalOptionElement.value = 'hexadecimal';
    hexadecimalOptionElement.textContent = 'Hexadecimal';
    selectElement.appendChild(hexadecimalOptionElement);

    const convertors = {
        binary: (a) => a.toString(2),
        hexadecimal: (a) => a.toString(16).toUpperCase(),
    };

   
    convertButton.addEventListener('click', () => {
        const number = Number(inputElement.value);
        const valueToConvertTo = selectElement.value;

        const result = convertors[valueToConvertTo](number);
        resultElement.value = result;
    });

}
