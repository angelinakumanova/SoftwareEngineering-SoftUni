function solve([encodedString, ...commands]) {
    let encodedWord = encodedString;

    for (const command of commands) {

        if (command === 'Buy') {
            console.log(`The cryptocurrency is: ${encodedWord}`);
            return;
        }

        if (command === 'TakeEven') {
            encodedWord = takeEven(encodedWord);
            
        } else if (command.includes('ChangeAll')) {
            const tokens = command.split('?');
            const substring = tokens[1];
            const replacement = tokens[2];

            encodedWord = changeAll(encodedWord, substring, replacement);
        } else if (command.includes('Reverse')) {
            const tokens = command.split('?');
            const substring = tokens[1];

            const result = reverse(encodedWord, substring);

            if (result === 'error') {
                console.log(result);
                continue;
            }

            encodedWord = result;
        }

        console.log(encodedWord);
        
    }

    function takeEven(word) {
        return (word.split('')).filter((_, index) => index % 2 === 0).join('');
    }
    
    function changeAll(word, substring, replacement) {

        while (word.includes(substring)) {
            word = word.replace(substring, replacement);
        }

        return word;
    }

    function reverse(word, substring) {
        if (word.includes(substring)) {
            const reversedSubstring = substring.split('').reverse().join('');
            word = word.replace(substring, '');

            word += reversedSubstring;

            return word;
        } 

        return 'error';
    }
}

solve((["z2tdsfndoctsB6z7tjc8ojzdngzhtjsyVjek!snfzsafhscs", 
    "TakeEven",
    "Reverse?!nzahc",
    "ChangeAll?m?g",
    "Reverse?adshk",
    "ChangeAll?z?i",
    "Buy"]));
