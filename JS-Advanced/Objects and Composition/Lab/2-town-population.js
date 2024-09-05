function solve(input) {
    const towns = [];

    for (const element of input) {
        const tokens = element.split(' <-> ');
        const townName = tokens[0];
        const population = Number(tokens[1]);

        if (towns.hasOwnProperty(townName)) {
            const updatedPopulation = towns[townName] + population;
            towns[townName] = updatedPopulation;
        } else {
            towns[townName] = population;
        }
    }

    for (const town in towns) {
        console.log(`${town} : ${towns[town]}`);
    }
}

solve(['Sofia <-> 1200000',
    'Montana <-> 20000',
    'New York <-> 10000000',
    'Washington <-> 2345000',
    'Las Vegas <-> 1000000']);
