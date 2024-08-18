function solve([numberOfSuperheroes, ...rest]) {
    const superheroes = (rest.slice(0, numberOfSuperheroes)).map(superhero => {
        const tokens = superhero.split('-');
        const name = tokens[0];
        const superpowers = tokens[1].split(',');
        const energy = Number(tokens[2]);
        
        return {
            name,
            superpowers,
            energy,
        };
    });
    
    const commands = rest.slice(numberOfSuperheroes);
    
    for (const command of commands) {
        
        if (command === 'Evil Defeated!') {
            printSuperheroes(superheroes);
            return;
        }
        
        const tokens = command.split(' * ');
        const action = tokens[0];
        const superheroName = tokens[1];
        
        const superhero = superheroes.find(superhero => superhero.name === superheroName);
        
        if (action === 'Use Power') {
            const superpower = tokens[2];
            const requiredEnergy = Number(tokens[3]);
            
            usePower(superhero, superpower, requiredEnergy);
        } else if (action === 'Train') {
            const trainingEnergy = Number(tokens[2]);
            
            train(superhero, trainingEnergy);
        } else if (action === 'Learn') {
            const newSuperpower = tokens[2];
            
            learnNewSuperpower(superhero, newSuperpower);
        }
    }
    
    
    function usePower(superhero, superpower, requiredEnergy) {
        if (superhero.superpowers.includes(superpower) && superhero.energy >= requiredEnergy) {
            superhero.energy -= requiredEnergy;
            
            console.log(`${superhero.name} has used ${superpower} and now has ${superhero.energy} energy!`);
            return;
            
        }
        
        console.log(`${superhero.name} is unable to use ${superpower} or lacks energy!`);
    }
    
    function train(superhero, trainingEnergy) {
        const currentSuperheroEnergy = superhero.energy;
        
        if (currentSuperheroEnergy === 100) {
            console.log(`${superhero.name} is already at full energy!`);
            return;
        }
        
        superhero.energy = Math.min(superhero.energy + trainingEnergy, 100);
        console.log(`${superhero.name} has trained and gained ${superhero.energy - currentSuperheroEnergy} energy!`);
        
    }
    
    function learnNewSuperpower(superhero, newSuperpower) {
        if (superhero.superpowers.includes(newSuperpower)) {
            console.log(`${superhero.name} already knows ${newSuperpower}.`);
            return;
        }
        
        superhero.superpowers.push(newSuperpower);
        console.log(`${superhero.name} has learned ${newSuperpower}!`);
        
    }
    
    function printSuperheroes(superheroes) {
        superheroes.forEach(superhero => {
            console.log(`Superhero: ${superhero.name}`);
            console.log(`- Superpowers: ${superhero.superpowers.join(', ')}`);
            console.log(`- Energy: ${superhero.energy}`);
        });
    }
}

solve(([
    "3",
    "Iron Man-Repulsor Beams,Flight-80",
    "Thor-Lightning Strike,Hammer Throw-10",
    "Hulk-Super Strength-60",
    "Use Power * Iron Man * Flight * 30",
    "Train * Thor * 20",
    "Train * Hulk * 50",
    "Learn * Hulk * Thunderclap",
    "Use Power * Hulk * Thunderclap * 70",
    "Evil Defeated!"
]));
