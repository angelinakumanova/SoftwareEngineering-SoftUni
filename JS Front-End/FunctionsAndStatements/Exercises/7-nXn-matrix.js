function printMatrix(number) {
    let output = String(number).repeat(number).replaceAll(String(number), `${String(number)} `).trim();

    for (let row = 0; row < number; row++) {
        console.log(output);
    }
}

printMatrix(3);
printMatrix(7);
printMatrix(2);
printMatrix(10);
