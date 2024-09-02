function solve(array) {
    const sum = array.reduce((prevValue, currentValue) => prevValue + currentValue, 0);
    const inverseSum =  array.reduce((prevValue, currentValue) => prevValue + 1 / currentValue, 0);
    const concatResult =  array.reduce((prevValue, currentValue) => prevValue + currentValue, '');

    console.log(sum);
    console.log(inverseSum);
    console.log(concatResult);
    
}

solve([1,2,3]);
