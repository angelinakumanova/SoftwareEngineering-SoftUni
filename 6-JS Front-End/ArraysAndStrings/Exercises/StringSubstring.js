function solve(word, text) {
    let pattern = new RegExp(`\\b${word}\\b`, 'i');

    let foundWord = text.match(pattern) ?? 0;

    console.log(foundWord.length === 1 ? word : `${word} not found!`);
}

solve('javascript','JavaScript is the best programming language');
solve('python','JavaScript is the best programming language');