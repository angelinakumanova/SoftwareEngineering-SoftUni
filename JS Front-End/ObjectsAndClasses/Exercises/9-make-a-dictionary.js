function solve(input) {
    const dictionary = {};

    for (const line of input) {
        const term = JSON.parse(line);
        
        for (const key in term) {
            dictionary[key] = term[key];
        }
    }

    Object.entries(dictionary).sort((firstTerm, secondTerm) => firstTerm[0].localeCompare(secondTerm[0])).forEach(([key, value]) => {
        console.log(`Term: ${key} => Definition: ${value}`);
    })

}

solve([
    '{"Coffee":"A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub."}',
    '{"Bus":"A large motor vehicle carrying passengers by road, typically one serving the public on a fixed route and for a fare."}',
    '{"Boiler":"A fuel-burning apparatus or container for heating water."}',
    '{"Tape":"A narrow strip of material, typically used to hold or fasten something."}',
    '{"Microphone":"An instrument for converting sound waves into electrical energy variations which may then be amplified, transmitted, or recorded."}'
    ]);
