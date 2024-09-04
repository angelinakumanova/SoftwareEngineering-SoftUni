function solve(array) {
    const result = array.filter((number, index) => index % 2 !== 0)
                        .map(num => num * 2)
                        .reverse()
                        .join(' ');

    console.log(result);
    
}

solve([10, 15, 20, 25]);
