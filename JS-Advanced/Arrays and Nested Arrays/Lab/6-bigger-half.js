function solve(array) {
    const halfLengthIndex = Math.floor(array.length / 2);
    const sortedHalfArray = array.sort((a,b) => a - b).slice(halfLengthIndex);

    return sortedHalfArray;
}

console.log(solve([4, 7, 2, 5]));
console.log(solve([3, 19, 14, 7, 2, 19, 6]));
