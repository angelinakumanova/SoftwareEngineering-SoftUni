function solve(array, rotations) {

    for (let i = 0; i < rotations; i++) {
        const lastElement = array.pop();
        array.unshift(lastElement);
    }

    console.log(array.join(' '));
}

solve(['1', '2', '3', '4'], 2);
solve(['Banana', 
    'Orange', 
    'Coconut', 
    'Apple'], 
    15);
