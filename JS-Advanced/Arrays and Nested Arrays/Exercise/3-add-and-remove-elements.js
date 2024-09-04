function solve(commands) {
    const array = [];
    let initialNumber;
    
    for (const command of commands) {
        if (command === 'add') {
            if (!initialNumber) { initialNumber = 1};
            array.push(initialNumber);
        } else if (command === 'remove') {
            if (initialNumber) { 
                array.pop();
                
            };
        }
        initialNumber++;
    }

    array.length === 0 ? console.log('Empty') : array.forEach(el => console.log(el));
    
    
}

solve(['add', 
    'add', 
    'remove', 
    'add', 
    'add']);
solve(['remove', 
    'remove', 
    'remove']);
