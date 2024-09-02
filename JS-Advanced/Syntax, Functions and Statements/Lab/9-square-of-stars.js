function solve(input) {
    const size = input == undefined ? 5 : input;

    for (let i = 1; i <= size; i++) {
        console.log('* '.repeat(size).trim());
    }
}


solve(2);
solve();
