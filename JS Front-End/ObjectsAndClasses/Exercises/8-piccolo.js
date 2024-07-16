function solve(input) {
    const parkingLot = [];

    for (const line of input) {
        const tokens = line.split(', ');
        const direction = tokens[0];
        const carNumber = tokens[1];

        const car = {};

        if (direction === 'IN') {
            if (!checkIfCarExists(carNumber)) {
                car.licenseNumber = carNumber;
                parkingLot.push(car);
            }
        } else if (direction === 'OUT') {
            if (checkIfCarExists(carNumber)) {
                const searchedCar = parkingLot.find(car => car.licenseNumber === carNumber);

                if (searchedCar) {
                    const index = parkingLot.indexOf(searchedCar);
                    parkingLot.splice(index, 1);
                }
            }
        }

        
    }
   
    if (parkingLot.length === 0) {
        console.log('Parking Lot is Empty');
    } else {
        Object.values(parkingLot)
        .sort((firstCar, secondCar) => firstCar.licenseNumber.localeCompare(secondCar.licenseNumber))
        .forEach((car) => console.log(car.licenseNumber));
    }


    function checkIfCarExists(carNumber) {
        return parkingLot.some(car => car.licenseNumber === carNumber);
    }
}

solve(['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'OUT, CA1234TA']);
solve(['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'IN, CA9999TT',
    'IN, CA2866HI',
    'OUT, CA1234TA',
    'IN, CA2844AA',
    'OUT, CA2866HI',
    'IN, CA9876HH',
    'IN, CA2822UU']);
