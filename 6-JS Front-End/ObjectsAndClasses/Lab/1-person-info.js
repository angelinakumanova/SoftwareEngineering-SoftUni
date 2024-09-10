function getPersonInfo(firstName, lastName, age) {
    const person = {
        firstName: firstName,
        lastName: lastName,
        age: age
    };

    return person;
}

console.log(getPersonInfo("Peter", "Pan", "20"));
