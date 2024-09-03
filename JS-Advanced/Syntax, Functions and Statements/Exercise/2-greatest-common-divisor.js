function solve(firstNum, secondNum) {
    let GCD = firstNum % secondNum;

    while (GCD !== 0) {
        firstNum = secondNum;
        secondNum = GCD;
        GCD = firstNum % secondNum;
    }

    console.log(secondNum);
    
}

solve(15, 5);
