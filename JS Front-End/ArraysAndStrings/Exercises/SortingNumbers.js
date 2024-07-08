function solve(array) {
    array.sort((a,b) => a - b);

    let left = 0;
    let right = array.length - 1;

    const result = [];

    while (left <= right) {
        if (left === right) {
            result.push(array[left]);
        } else {
            result.push(array[left]);
            result.push(array[right]);
        }

        left++;
        right--;
    }
    
    return result;
}

solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);