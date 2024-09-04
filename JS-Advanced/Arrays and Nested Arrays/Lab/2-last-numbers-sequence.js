function solve(firstNum, secondNum) {
    const sequence = [1];

    for (let i = 1; i < firstNum; i++) {
        let sum = 0;

        for (let j = i - secondNum; j < i; j++) {
            if (j >= 0) {
                sum += sequence[j];
            }
        }

        sequence.push(sum);
    }

    return sequence;
    
}

console.log(solve(6,3));
