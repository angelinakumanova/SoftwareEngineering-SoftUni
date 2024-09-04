function solve(array, delimiter) {
    const result = array.join(`${delimiter}`);

    console.log(result);
}

solve(['One', 
    'Two', 
    'Three', 
    'Four', 
    'Five'], 
    '-');
