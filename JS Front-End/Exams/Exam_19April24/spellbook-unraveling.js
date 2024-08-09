function solve(input) {
    let [spell, ...commands] = input;

    

    for (const command of commands) {
        if (command === 'RemoveEven') {
            spell = removeEven(spell);
        } else if (command.includes('TakePart!')) {
            const [_,...indices] = command.split('!');
            spell = takePart(indices, spell);
        } else if (command.includes("Reverse!")) {
            const substring = command.split('!')[1];

            if (!spell.includes(substring)) {
                console.log('Error');
                continue;
            } else {
                spell = reverse(spell, substring);
            }
        } else {
            console.log(`The concealed spell is: ${spell}`);
            break;
        }
        console.log(spell);
    }


    function removeEven(spell) {
        const characters = spell.split('');

        return characters.filter((char, index) => index % 2 === 0).join('');
    }

    function takePart(indices, spell) {
        const startingIndex = indices[0];
        const endIndex = indices[1];
        return spell.substring(startingIndex, endIndex);
    }

    function reverse(spell, substring) {
        spell = spell.replace(substring, '');
        substring = substring.split('').reverse().join('');

        return spell += substring;
    }
}

solve((["asAsl2adkda2mdaczsa", 
    "RemoveEven",
    "TakePart!1!9",
    "Reverse!maz",
    "End"]));
