function solve(input) {
    const regex = /\w+/g;
    const matchedStrings = input.match(regex);

    const result = matchedStrings.map(str => str.toUpperCase()).join(', ');
    console.log(result);
    
}

solve('Hi, how are you?');
