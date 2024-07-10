function printResult(base, power) {
    console.log(recursivePower(base, power));

    function recursivePower(base, power) {
        if (power === 1) {
            return base;
        }
        
        return base * recursivePower(base, power - 1);
    }
}

printResult(2, 8);
printResult(3, 4);
