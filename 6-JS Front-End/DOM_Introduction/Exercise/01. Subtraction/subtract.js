function subtract() {
    const firstNumElement = document.getElementById('firstNumber');
    const secondNumElement = document.getElementById('secondNumber');

    const firstNum = Number(firstNumElement.value);
    const secondNum = Number(secondNumElement.value);

    const resultElement = document.getElementById('result');
    resultElement.textContent = firstNum - secondNum;
}
