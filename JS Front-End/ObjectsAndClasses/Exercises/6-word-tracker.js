function solve(input) {
    const searchedWords = input[0].split(/\s+/);
    const wordsTracker = {};
    for (const word of searchedWords) {
        wordsTracker[word] = 0;
    }

    for (const line of input.slice(1)) {
        if (wordsTracker.hasOwnProperty(line)) {
            wordsTracker[line] += 1;
        }
    }

    Object.entries(wordsTracker)
    .sort((firstWordOccurrences, secondWordOccurences) => secondWordOccurences[1] - firstWordOccurrences[1])
    .forEach(([word, value]) => console.log(`${word} - ${value}`));
}

solve([
    'this sentence', 
    'In', 'this', 'sentence', 'you', 'have', 'to', 'count', 'the', 'occurrences', 'of', 'the', 'words', 'this', 'and', 'sentence', 'because', 'this', 'is', 'your', 'task'
    ]
    );

solve([
    'is the', 
    'first', 'sentence', 'Here', 'is', 'another', 'the', 'And', 'finally', 'the', 'the', 'sentence']
    );
