function printJSON(firstName, lastName, hairColor) {
    const person = createObject(firstName, lastName, hairColor);
    console.log(convertObjToJSON(person));
    
    
    function createObject(firstName, lastName, hairColor) {
        const person = {
            name: firstName,
            lastName: lastName,
            hairColor: hairColor
        };
        
        return person;
    }
    
    function convertObjToJSON(obj) {
            return JSON.stringify(obj);
    }
}


printJSON('George', 'Jones', 'Brown');
