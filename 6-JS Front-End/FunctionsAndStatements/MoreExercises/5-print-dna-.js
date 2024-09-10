function solve(length) {
    const sequence = 'ATCGTTAGGG'.split('');
    const templates = new Map([
        [1, '**??**'],
        [2, '*?--?*'],
        [3, '?----?'],
        [4, '*?--?*']
    ]);
    let currentSeqIndex = 0;
    let currentRowIdx = 1;

    for(let row = 0; row < length; row++) {
        
        console.log(createRow(sequence, currentRowIdx));
        currentRowIdx++;
        if (currentRowIdx === 5) {
            currentRowIdx = 1;
        }
    }

    function createRow(sequence, currentRowIdx) {
        let currentRow = templates.get(currentRowIdx);

        for(let i = 0; i < 2; i++) {    
            while((/[?]/).test(currentRow)) {
                currentRow = currentRow.replace('?', sequence[currentSeqIndex++]);
            }
        }
        
        if (currentSeqIndex === sequence.length) {
            currentSeqIndex = 0;
        }

        

        return currentRow;
    }
}

solve(4);
solve(10);
