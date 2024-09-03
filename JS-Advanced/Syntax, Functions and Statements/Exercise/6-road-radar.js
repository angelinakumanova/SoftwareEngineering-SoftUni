function solve(speed, area) {
    const areasLimit = {
        'motorway': 130,
        'interstate': 90,
        'city': 50,
        'residential': 20,
    };

    const limit = areasLimit[area];

    if (limit >= speed) {
        console.log(`Driving ${speed} km/h in a ${limit} zone`);
    } else {
        const speeding = speed - limit;
        let status;

        if (speeding <= 20) {
            status = 'speeding';
        } else if (speeding <= 40) {
            status = 'excessive speeding'
        } else {
            status = 'reckless driving';
        }

        console.log(`The speed is ${speeding} km/h faster than the allowed speed of ${limit} - ${status}`);
        
    }
}

solve(40, 'city');
solve(200, 'motorway');
solve(21, 'residential');
