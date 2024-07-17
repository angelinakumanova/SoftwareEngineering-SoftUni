function solve(cars) {
    const garages = {};

    /*['1 - color: blue, fuel type: diesel',
    '1 - color: red, manufacture: Audi',
    '2 - fuel type: petrol',
    '4 - color: dark blue, fuel type: diesel, manufacture: Fiat'] */

    for (const car of cars) {
        const tokens = car.split(' - ');
        const garage = tokens[0];
        const carObj = {};

        if (!garages.hasOwnProperty(garage)) {
            garages[garage] = [];
        }

        const carInfo = tokens[1].split(', ');
        for (const info of carInfo) {
            const details = info.split(': ');
            const key = details[0];
            const value = details[1];

            carObj[key] = value;
        }

        garages[garage].push(carObj);
    }
    /*Garage № 1
    --- color - blue, fuel type - diesel
    --- color - red, manufacture - Audi */

    Object.entries(garages).forEach(([key, value]) => {
        console.log(`Garage № ${key}`);
        value.forEach((car) => {

            let output = [];
            for (const carKey in car) {
                output.push(`${carKey} - ${car[carKey]}`)
            }

            console.log(`--- ${output.join(', ')}`);
        })
    });
}

solve(['1 - color: blue, fuel type: diesel', '1 - color: red, manufacture: Audi', '2 - fuel type: petrol', '4 - color: dark blue, fuel type: diesel, manufacture: Fiat']);
