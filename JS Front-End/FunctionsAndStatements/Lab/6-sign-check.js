function solve(firstNumber, secondNumber, thirdNumber) {
    function multiply(a, b) {
        return a * b;
    }

    let result = multiply(firstNumber, multiply(secondNumber, thirdNumber));

    if (result >= 0) {
        console.log("Positive");
    } else {
        console.log("Negative");
    }
}

solve(5, 12, -15);
solve (-6, -12, 14);
