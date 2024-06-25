function converToUppercase(text) {
    let words = text.match(/\w+/g);

    let wordsAsUpperCase = words.map(word => word.toUpperCase());
    console.log(wordsAsUpperCase.join(', '));
}

converToUppercase('Hi, how are you?');
converToUppercase('hello');