function solve(firstInput, secondInput) {
    const firstNumber = Number(firstInput);
    const secondNumber = Number(secondInput);

    let result = 0;
    for (let i = firstNumber; i <= secondNumber; i++) {
        result += i;
    }

    console.log(result);
}

solve('1', '5');
