function printPerson(age) {
    let person = 'out of bounds';
    if (age >= 0 && age <= 2) {
        person = 'baby';
    } else if (age >= 3 && age <= 13) {
        person = 'child';
    } else if (age >= 14 && age <= 19) {
        person = 'teenager';
    } else if (age >= 20 && age <= 65) {
        person = 'adult';
    } else if (age >= 66) {
        person = 'elder';
    }

    console.log(person);
}

printPerson(2);
printPerson(100);
printPerson(20);
printPerson(-1);