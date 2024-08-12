function solve([numberOfAstronauts, ...rest]) {
    const astronauts = (rest.slice(0, numberOfAstronauts)).map(astronaut => {
        const tokens = astronaut.split(' ');
        const name = tokens[0];
        const oxygen = Number(tokens[1]);
        const energy = Number(tokens[2]);

        return {
            name,
            oxygen,
            energy,
        };
    });

    
    const commands = rest.slice(numberOfAstronauts);

    for (const command of commands) {

        if (command === 'End') {
            printAstronauts(astronauts);
            return;
        }

        const tokens = command.split(' - ');
        const action = tokens[0];
        const astronautName = tokens[1];
        const astronaut = astronauts.find(a => a.name === astronautName);

        if (action === 'Explore') {
            const energyNeeded = Number(tokens[2]);

            explore(astronaut, energyNeeded);
        } else if (action === 'Refuel') {
            const amount = Number(tokens[2]);

            refuel(astronaut, amount);
        } else if (action === 'Breathe') {
            const amount = Number(tokens[2]);

            breathe(astronaut, amount);
        }
    }


    function explore(astronaut, energyNeeded) {

        if (astronaut.energy >= energyNeeded) {
            const leftEnergy = astronaut.energy -= energyNeeded;

            console.log(`${astronaut.name} has successfully explored a new area and now has ${leftEnergy} energy!`);
            return;
        }

        console.log(`${astronaut.name} does not have enough energy to explore!`);
    }

    function refuel(astronaut, amount) {
        const initialEnergy = astronaut.energy;
        astronaut.energy = Math.min(astronaut.energy + amount, 200);
        
        console.log(`${astronaut.name} refueled their energy by ${astronaut.energy - initialEnergy}!`);
        return;
    }

    function breathe(astronaut, amount) {
        const initialOxygen = astronaut.oxygen;
        astronaut.oxygen = Math.min(astronaut.oxygen + amount, 100);
        
        console.log(`${astronaut.name} took a breath and recovered ${astronaut.oxygen - initialOxygen} oxygen!`);
        return;
    }

    function printAstronauts(astronauts) {
        astronauts.forEach(astronaut => {
            console.log(`Astronaut: ${astronaut.name}, Oxygen: ${astronaut.oxygen}, Energy: ${astronaut.energy}`);
        });
    }
}

solve([  '3',
    'John 50 120',
    'Kate 80 180',
    'Rob 70 150',
    'Explore - John - 50',
    'Refuel - Kate - 30',
    'Breathe - Rob - 20',
    'End']);
