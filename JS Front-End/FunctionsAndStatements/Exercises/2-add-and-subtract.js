function sum(a, b) {
    return a + b;
}

function subtract(a, b) {
    return a - b;
}

function printResult(firstNumber, secondNumber, thirdNumber) {
    let result = sum(firstNumber, secondNumber);
    result = subtract(result, thirdNumber);


    console.log(result);
}

printResult(23, 6, 10);
printResult(1, 17, 30);
printResult(42, 58, 100);
