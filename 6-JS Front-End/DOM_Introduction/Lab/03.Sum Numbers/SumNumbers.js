function calc() {
    const firstNumElement = document.getElementById('num1').value;
    const secondNumElement = document.getElementById('num2').value;
    const sumElement = document.getElementById('sum');

    const firstNum = Number(firstNumElement);
    const secondNum = Number(secondNumElement);

    sumElement.value = firstNum + secondNum;
}
