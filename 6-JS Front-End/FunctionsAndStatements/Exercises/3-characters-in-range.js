function printCharacters(firstCharacter, secondCharacter) {
    console.log(findASCIICharacters(firstCharacter, secondCharacter));
    
    function findASCIICharacters(firstCharacter, secondCharacter) {
        let firstCharacterCode = firstCharacter.charCodeAt(0);
        let secondCharacterCode = secondCharacter.charCodeAt(0);
        
        let biggestCodeNumber = Math.max(firstCharacterCode, secondCharacterCode) - 1;
        let smallestCodeNumber = Math.min(firstCharacterCode, secondCharacterCode) + 1;
        
        let result = '';
        for (let i = smallestCodeNumber; i <= biggestCodeNumber; i++) {
            result += String.fromCharCode(i) + ' ';
        }

        return result;
    }   
}

printCharacters('a', 'd');
printCharacters('#', ':');
printCharacters('C', '#');
