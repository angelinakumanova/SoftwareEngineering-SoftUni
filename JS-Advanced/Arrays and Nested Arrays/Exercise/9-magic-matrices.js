function solve(matrix) {
    const rowSums = matrix.map(row => row.reduce((sum, num) => sum + num, 0));
    
    const colSums = matrix[0].map((_, colIndex) => 
        matrix.reduce((sum, row) => sum + row[colIndex], 0));
    
    const allRowsEqual = rowSums.every(sum => sum === rowSums[0]);
    
    const allColsEqual = colSums.every(sum => sum === rowSums[0]);
    
    console.log(allRowsEqual && allColsEqual);
}

solve([[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]]);
    