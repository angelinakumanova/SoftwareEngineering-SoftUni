function solve([numberOfRacers, ...rest]) {
    const racers = (rest.slice(0, numberOfRacers)).map(racer => {
        const tokens = racer.split('\|');
        const name = tokens[0];
        const fuel = Math.min((Number(tokens[1])), 100);
        const position = Number(tokens[2]);

        return {
            name,
            fuel,
            position,
        };
    });

    const commands = rest.slice(numberOfRacers);

    for (const command of commands) {

        if (command === 'Finish') {
            printRacers(racers);
            return;
        }

        const tokens = command.split(' - ');
        const action = tokens[0];
        const name = tokens[1];
        const racer = racers.find(racer => racer.name === name);

        if (action === 'StopForFuel') {
            const minimumFuel = Number(tokens[2]);
            const changedPos = Number(tokens[3]);

            // check if needed to change fuel to 100
            stopForFuel(racer, minimumFuel, changedPos);
        } else if (action === 'Overtaking') {
            const secondRacer = racers.find(racer => racer.name === tokens[2]);

            overTake(racer, secondRacer);
        } else if (action === 'EngineFail') {
            const leftLaps = tokens[2];

            failEngine(racers, racer, leftLaps);
            
        }
    }


    function stopForFuel(racer, minimumFuel, changedPos) {

        if (racer.fuel < minimumFuel) {
            racer.position = changedPos;
            console.log(`${racer.name} stopped to refuel but lost his position, now he is ${changedPos}.`);
            
            return;
        }

        console.log(`${racer.name} does not need to stop for fuel!`)
    }

    function overTake(firstRacer, secondRacer) {
        const firstRacerPos = firstRacer.position;
        const secondRacerPos = secondRacer.position;

        if (firstRacerPos < secondRacerPos) {
            firstRacer.position = secondRacerPos;
            secondRacer.position = firstRacerPos;

            console.log(`${firstRacer.name} overtook ${secondRacer.name}!`);
            return;
            
        }
    }

    function failEngine(racers, racer, laps) {
        const indexOfRacer = racers.indexOf(racer);
        racers.splice(indexOfRacer, 1);

        console.log(`${racer.name} is out of the race because of a technical issue, ${laps} laps before the finish.`);
    }

    function printRacers(racers) {
        racers.forEach(racer => {
            console.log(racer.name);
            console.log(`  Final position: ${racer.position}`);
        });
    }
}

solve((["3",
    "Valentino Rossi|100|1",
    "Marc Marquez|90|2",
    "Jorge Lorenzo|80|3",
    "StopForFuel - Valentino Rossi - 50 - 1",
    "Overtaking - Marc Marquez - Jorge Lorenzo",
    "EngineFail - Marc Marquez - 10",
    "Finish"]));
