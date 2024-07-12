function printResult(firstNumber, secondNumber) {
    let firstFactorial = calculateTheFactorial(firstNumber);
    let secondFactorial = calculateTheFactorial(secondNumber);

    let resultOfFactorialDivision = divideFactorials(firstFactorial, secondFactorial);

    console.log(resultOfFactorialDivision);
    
    function divideFactorials(firstNumber, secondNumber) {
        return (firstNumber / secondNumber).toFixed(2);
    }
    
    function calculateTheFactorial(number) {
        if (number === 1) {
            return 1;
        }
        
        return number * calculateTheFactorial(number - 1);
    }
}



printResult(5, 2);
printResult(6, 2);
