function solve(array) {
    const result = array.sort((a, b) => {
        if (a.length !== b.length) {
            return a.length - b.length;
        }

        return a.toLowerCase().localeCompare(b.toLowerCase());
    });

    result.forEach(el => console.log(el));
}

solve(['alpha', 
    'beta', 
    'gamma']);
solve(['Isacc', 
    'Theodor', 
    'Jack', 
    'Harrison', 
    'George']);
