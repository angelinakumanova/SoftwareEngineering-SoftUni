function sum(array, startIndex, endIndex) {
    if (!Array.isArray(array)) {
        return NaN;
    }

    startIndex = startIndex < 0 ? 0 : startIndex;
    endIndex = endIndex >= array.length ? array.length - 1 : endIndex;

    const summingArray = array.slice(startIndex, endIndex + 1).map(Number);

    const sum = summingArray.reduce((prevVal, currentVal) => prevVal + currentVal, 0);

    return Math.round(sum * 10) / 10;
}

console.log(sum([10, 20, 30, 40, 50, 60], 3, 300));
console.log(sum([1.1, 2.2, 3.3, 4.4, 5.5], -3, 1));
console.log(sum([10, 'twenty', 30, 40], 0, 2));
console.log(sum([], 1, 2));
console.log(sum('text', 0, 2));


