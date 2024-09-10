function solve(input) {

    for (const line of input) {
        const tokens = line.split(' | ');
        const town = tokens[0];
        const latitude = Number(tokens[1]).toFixed(2);
        const longitude = Number(tokens[2]).toFixed(2);

        const townObj = {
            town,
            latitude,
            longitude,
        }

        console.log(townObj);
    }

    
}

solve(['Sofia | 42.696552 | 23.32601',
    'Beijing | 39.913818 | 116.363625']
    );
