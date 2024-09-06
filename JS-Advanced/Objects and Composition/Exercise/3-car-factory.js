function createCar(car) {
    return {
        'model': car.model,
        'engine': createEngine(car.power),
        'carriage': createCarriage(car.carriage, car.color),
        'wheels': createWheels(car.wheelsize),
    };


    function createEngine(power) {
        if (power <= 90) {
            return {
                'power': 90,
                'volume': 1800, 
            };
        } else if (power <= 120) {
            return {
                'power': 120,
                'volume': 2400,
            };
        } else {
            return {
                'power': 200,
                'volume': 3500,
            };
        }
    }

    function createCarriage(type, color) {
        return {
            type,
            color,
        };
    }

    function createWheels(wheelSize) {
        if (wheelSize % 2 === 0) {
            wheelSize -= 1;
        }

        return [0, 0, 0, 0].fill(wheelSize, 0);
    }
}

console.log(createCar({ model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14 }));
