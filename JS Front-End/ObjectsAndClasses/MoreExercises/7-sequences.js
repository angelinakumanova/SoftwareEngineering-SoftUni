function solve(sequences) {
    const setOfUniqueArrays = new Set();
    const uniqueArrays = [];

    for (let sequence of sequences) {
        sequence = JSON.parse(sequence);
        
        const sortedSeq = sequence.sort((a, b) => b - a);

        const sequenceAsString = JSON.stringify(sortedSeq);

        if(!setOfUniqueArrays.has(sequenceAsString)) {
            uniqueArrays.push(sortedSeq);
            setOfUniqueArrays.add(sequenceAsString);
        }

    }

    uniqueArrays.sort((a, b) => a.length - b.length).forEach(array => {
        console.log(`[${array.join(', ')}]`);
    });
}

solve(["[-3, -2, -1, 0, 1, 2, 3, 4]",
    "[10, 1, -17, 0, 2, 13]",
    "[4, -3, 3, -2, 2, -1, 1, 0]"]);

solve(["[7.14, 7.180, 7.339, 80.099]",
    "[7.339, 80.0990, 7.140000, 7.18]",
    "[7.339, 7.180, 7.14, 80.099]"]);
