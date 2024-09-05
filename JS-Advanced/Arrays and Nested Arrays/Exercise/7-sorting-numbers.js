function solve(array) {
    const sortedArray = array.sort((a,b) => a - b);

    const result = [];
    let leftIndex = 0;
    let rightIndex = sortedArray.length - 1;

    while (leftIndex <= rightIndex) {
        if (leftIndex <= rightIndex) result.push(sortedArray[leftIndex++]);
        if (leftIndex <= rightIndex) result.push(sortedArray[rightIndex--]);
    }

    return result;
}

console.log(solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));
//[-3, 65, 1, 63, 3, 56, 18, 52, 31, 48]
console.log(solve([22, 9, 63, 3, 2, 19, 54, 11, 21, 18]));
//[2, 63, 3, 54, 9, 22, 11, 21, 18, 19]
console.log(solve([1,5,3]));

