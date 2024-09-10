function calcuate(firstNumber, operator, secondNumber) {
    if (operator == '+' ) {
        console.log((firstNumber + secondNumber).toFixed(2));
    } else if (operator == '-') {
        console.log((firstNumber - secondNumber).toFixed(2));
    } else if (operator == '/') {
        console.log((firstNumber / secondNumber).toFixed(2));
    } else if (operator == '*') {
        console.log((firstNumber * secondNumber).toFixed(2));
    }
}

calcuate(5, '+', 10);
calcuate(25.5, '-', 3);