function washCar(operations) {
    const mapOfOperations = new Map([
        ['soap', (a) => a + 10],
        ['water', (a) => a * 1.2],
        ['vacuum cleaner', (a) => a * 1.25],
        ['mud', (a) => a * 0.9]
    ]);
    let carCleaniness = 0;

    for (const operation of operations) {
        carCleaniness = mapOfOperations.get(operation)(carCleaniness);
    }

    console.log(`The car is ${carCleaniness.toFixed(2)}% clean.`);
}

washCar(['soap', 'soap', 'vacuum cleaner', 'mud', 'soap', 'water']);
washCar(["soap", "water", "mud", "mud", "water", "mud", "vacuum cleaner"]);
