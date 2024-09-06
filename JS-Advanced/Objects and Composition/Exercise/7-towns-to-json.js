function solve(input) {
    const [_, firstHeader, secondHeader, thirdHeader] = input[0].split(/\s*\|\s*/);
    
    const townsInput = input.slice(1);
    
    const towns = [];
    for (const town of townsInput) {
        const[_, name, latitude, longitude] = town.split(/\s*\|\s*/);
        const townObj = {};
        townObj[firstHeader] = name;
        townObj[secondHeader] = Number(Number(latitude).toFixed(2));
        townObj[thirdHeader] = Number(Number(longitude).toFixed(2));

        towns.push(townObj);
    }

    console.log(JSON.stringify(towns));
    
}

solve(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']);
