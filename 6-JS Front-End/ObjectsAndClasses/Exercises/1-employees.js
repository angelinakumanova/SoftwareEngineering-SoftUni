function solve(input) {
    const employees = [];

    for (const line of input) {
        const personalNumber = line.length;
        const employee = {
            name: line,
            personalNumber,
        }

        employees.push(employee);
    }

    employees.forEach(e => {
        console.log(`Name: ${e.name} -- Personal Number: ${e.personalNumber}`);
    });
}

solve([
    'Silas Butler',
    'Adnaan Buckley',
    'Juan Peterson',
    'Brendan Villarreal'
    ]);
