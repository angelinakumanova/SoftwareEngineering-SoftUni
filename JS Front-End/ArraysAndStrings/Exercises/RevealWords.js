function solve(words, text) {
    words.split(', ').forEach((word) => {
        const searchedValue = '*'.repeat(word.length);
        text = text.replace(searchedValue, word);
    });

    console.log(text);
}

solve('great','softuni is ***** place for learning new programming languages');
solve('great, learning','softuni is ***** place for ******** new programming languages')