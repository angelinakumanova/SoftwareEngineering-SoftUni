function printNumber(firstNumber, secondNumber, thirdNumber) {
    console.log(findSmallestNumber(firstNumber, secondNumber, thirdNumber));

    function findSmallestNumber(firstNumber, secondNumber, thirdNumber) {
        let result = Math.min(firstNumber, Math.min(secondNumber, thirdNumber));
    
        return result;
    }
}

printNumber(2, 5, 3);
printNumber(600, 342, 123);
printNumber(25, 21, 4);
printNumber(2, 2, 2);
