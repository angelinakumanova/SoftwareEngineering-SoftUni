function solve(matrix) {
    const mainDiagonalSum = matrix.reduce((sum, row, i) => sum + row[i], 0);
    const secondaryDiagonalSum = matrix.reduce((sum, row, i) => sum + row[row.length - 1 - i], 0);

    console.log(mainDiagonalSum + ' ' + secondaryDiagonalSum);
}

solve([[3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]]);
