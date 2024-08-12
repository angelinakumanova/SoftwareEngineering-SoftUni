function solve([numberOfBaristas, ...rest]) {
    const baristas = (rest.slice(0, numberOfBaristas)).map(barista => {
        const [name, shift, coffeeTypesString] = barista.split(' ');
        const coffeeTypes = coffeeTypesString.split(',');

        return {
            name,
            shift,
            coffeeTypes,
        };
    });

    const commands = rest.slice(numberOfBaristas);
    
    for (const command of commands) {
        
        if (command === 'Closed') {
            printBaristas(baristas);
            break;
        }

        const tokens = command.split(' / ');
        const action = tokens[0];
        const baristaName = tokens[1];
        const barista = baristas.find(brsta => brsta.name === baristaName);

        if (action === 'Prepare') {
            const shift = tokens[2];
            const coffeeType = tokens[3];

            prepareCoffee(barista, shift, coffeeType);
        } else if (action === 'Change Shift') {
            const newShift = tokens[2];

            changeShift(barista, newShift);
        } else if (action === 'Learn') {
            const newCoffeeType = tokens[2];

            learnNewCoffeeType(barista, newCoffeeType);
        }

    }


    function prepareCoffee(barista, shift, coffeeType) {
        
        if (barista.shift !== shift || !barista.coffeeTypes.includes(coffeeType)) {
            console.log(`${barista.name} is not available to prepare a ${coffeeType}.`);
            return;
        }

        console.log(`${barista.name} has prepared a ${coffeeType} for you!`);

    }

    function changeShift(barista, newShift) {
        barista.shift = newShift;

        console.log(`${barista.name} has updated his shift to: ${newShift}`);
    }

    function learnNewCoffeeType(barista, newCoffeeType) {

        if (barista.coffeeTypes.includes(newCoffeeType)) {
            console.log(`${barista.name} knows how to make ${newCoffeeType}.`);
            return;
        }

        barista.coffeeTypes.push(newCoffeeType);

        console.log(`${barista.name} has learned a new coffee type: ${newCoffeeType}.`);
    }

    function printBaristas(baristas) {
        baristas.forEach(barista => {
            console.log(`Barista: ${barista.name}, Shift: ${barista.shift}, Drinks: ${barista.coffeeTypes.join(', ')}`);
        });
    }
}

solve([
    '3',
      'Alice day Espresso,Cappuccino',
      'Bob night Latte,Mocha',
      'Carol day Americano,Mocha',
      'Prepare / Alice / day / Espresso',
      'Change Shift / Bob / night',
      'Learn / Carol / Latte',
      'Learn / Bob / Latte',
      'Prepare / Bob / night / Latte',
      'Closed']);
