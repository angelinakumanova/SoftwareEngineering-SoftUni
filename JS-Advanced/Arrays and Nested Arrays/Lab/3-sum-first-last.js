function solve(array) {
    const firstElement = Number(array[0]);
    const lastElement = Number(array[array.length - 1]);

    const sum = firstElement + lastElement;

    return sum;
    
}

console.log(solve(['20', '30', '40']));
