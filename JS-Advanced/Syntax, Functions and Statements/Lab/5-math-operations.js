function solve(firstNumber, secondNumber, operator) {
    const operators = {
        '+': (a,b) => a + b,
        '-': (a,b) => a - b,
        '*': (a,b) => a * b,
        '/': (a,b) => a / b,
        '%': (a,b) => a % b,
        '**': (a,b) => a ** b,
    };

    const result = operators[operator](firstNumber, secondNumber);

    console.log(result);
}

solve(5,6,'+');
