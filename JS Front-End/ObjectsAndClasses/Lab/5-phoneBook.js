function solve(people) {
    const phoneBook = {};

    for (const person of people) {
        const tokens = person.split(' ');
        const name = tokens[0];
        const number = tokens[1];
        phoneBook[name] = number;
    }

    for (const key in phoneBook) {
        console.log(`${key} -> ${phoneBook[key]}`)
    }
}

solve(['Tim 0834212554', 'Peter 0877547887', 'Bill 0896543112', 'Tim 0876566344']);
