function printResult(firstNumber, secondNumber) {
    const firstFactorial = calculateFactorial(firstNumber);
    const secondFactorial = calculateFactorial(secondNumber);

    const resultOfFactorialDivision = divideFactorials(firstFactorial, secondFactorial);

    console.log(resultOfFactorialDivision);
    
    function divideFactorials(firstNumber, secondNumber) {
        return (firstNumber / secondNumber).toFixed(2);
    }
    
    function calculateFactorial(number) {
        if (number === 1) {
            return 1;
        }
        
        return number * calculateFactorial(number - 1);
    }
}



printResult(5, 2);
printResult(6, 2);
