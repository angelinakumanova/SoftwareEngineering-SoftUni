function solve(input) {
    const flightsSectors = input[0];
    const flights = {};

    for (const flight of flightsSectors) {
        const tokens = flight.split(' ');
        const sector = tokens[0];
        const destination = flight.substring(sector.length + 1);

        flights[sector] = destination;
    }


    const newlyChangedStatuses = input[1];
    const sectorsWithChangedStatuses = {};
    for (const status of newlyChangedStatuses) {
        const tokens = status.split(' ');
        const sector = tokens[0];
        const destination = flights[sector];

        if (flights.hasOwnProperty(sector)) {
            sectorsWithChangedStatuses[destination] = 'Cancelled';
            delete flights[sector]
        }
        
    }

    const wantedStatus = (input[2])[0];
    if (wantedStatus === 'Cancelled') {
        Object.entries(sectorsWithChangedStatuses).sort((a, b) => a[0].localeCompare(b[0])).forEach(([key, value]) => {
            console.log(`{ Destination: '${key}', Status: 'Cancelled' }`);
        })
    } else if (wantedStatus === 'Ready to fly') {
        Object.entries(flights).forEach(([key, value]) => {
            console.log(`{ Destination: '${value}', Status: 'Ready to fly' }`);
        })
    }

}

solve([['WN269 Delaware',
    'FL2269 Oregon',
     'WN498 Las Vegas',
     'WN3145 Ohio',
     'WN612 Alabama',
     'WN4010 New York',
     'WN1173 California',
     'DL2120 Texas',
     'KL5744 Illinois',
     'WN678 Pennsylvania'],
     ['DL2120 Cancelled',
     'WN612 Cancelled',
     'WN1173 Cancelled',
     'SK430 Cancelled'],
     ['Cancelled']
 ]);
solve([['WN269 Delaware',
    'FL2269 Oregon',
     'WN498 Las Vegas',
     'WN3145 Ohio',
     'WN612 Alabama',
     'WN4010 New York',
     'WN1173 California',
     'DL2120 Texas',
     'KL5744 Illinois',
     'WN678 Pennsylvania'],
     ['DL2120 Cancelled',
     'WN612 Cancelled',
     'WN1173 Cancelled',
     'SK330 Cancelled'],
     ['Ready to fly']]);
