function solve(array, n) {
    const modifiedArray = [];
    for (let i = 0; i < array.length; i += n) {
        modifiedArray.push(array[i]);
    }

    return modifiedArray;
}

console.log(solve(['5', 
    '20', 
    '31', 
    '4', 
    '20'], 
    2));
