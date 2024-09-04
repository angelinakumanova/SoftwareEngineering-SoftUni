function solve(matrix) {
    const sortedMatrix = matrix.flat().sort((a,b) => b - a);
    const biggestElement = sortedMatrix[0];

    return biggestElement;
}

console.log(
    solve([[20, 50, 10],
        [8, 33, 145]]));
