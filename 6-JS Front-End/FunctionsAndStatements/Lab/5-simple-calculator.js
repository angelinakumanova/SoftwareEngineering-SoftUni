function solve(firstNumber, secondNumber, operation) {
    const map = new Map([
        ['multiply', (a,b) => a * b],
        ['divide', (a, b) => a / b],
        ['add', (a, b) => a + b],
        ['subtract', (a,b) => a - b]
    ]);

    let result = map.get(operation)(firstNumber, secondNumber);
    console.log(result);
}

solve(5, 5, 'multiply');
solve(40, 8, 'divide');
solve(12, 19, 'add');
solve(50, 13, 'subtract');
