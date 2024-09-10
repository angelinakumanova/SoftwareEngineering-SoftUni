function solve(input) {
    const horses = input[0].split('\|');
    
    const commands = input.slice(1);
    
    for (const command of commands) {
        
        if (command === 'Finish') {
            printHorses(horses);
            return;
        }
        
        const tokens = command.split(' ');
        const action = tokens[0];
        const horse = tokens[1];
        
        if (action === 'Retake') {
            const secondHorse = tokens[2]
            
            retake(horse, secondHorse, horses);
        } else if (action === 'Trouble') {
            
            trouble(horses, horse);
        } else if (action === 'Rage') {
            
            rage(horse, horses);
        } else if (action === 'Miracle') {
            
            miracle(horses);
        }
    }
    
    function retake(overTakingHorse, overTakenHorse, horses) {
        const overTakingHorsePos = horses.indexOf(overTakingHorse);
        const overTakenHorsePos = horses.indexOf(overTakenHorse);
        
        if (overTakingHorsePos < overTakenHorsePos) {
            horses[overTakingHorsePos] = overTakenHorse;
            horses[overTakenHorsePos] = overTakingHorse;
            
            console.log(`${overTakingHorse} retakes ${overTakenHorse}.`);
            
        }
    }
    
    function trouble(horses, horse) {
        const currentHorsePos = horses.indexOf(horse);
        
        if (currentHorsePos > 0) {
            horses.splice(currentHorsePos, 1);
            horses.splice(currentHorsePos - 1, 0, horse);
            
            console.log(`Trouble for ${horse} - drops one position.`);
            
        }
    }
    
    function rage(horse, horses) {

        for (let i = 0; i < 2; i++) {
            const currentHorsePos = horses.indexOf(horse);

            if (currentHorsePos < horses.length - 1) {
                horses[currentHorsePos] = horses[currentHorsePos + 1];
                horses[currentHorsePos + 1] = horse;
            }
        }
        
        console.log(`${horse} rages 2 positions ahead.`);
    }
    
    function miracle(horses) {
        const lastHorse = horses.shift();
        
        horses.push(lastHorse);
        
        console.log(`What a miracle - ${lastHorse} becomes first.`);
    }
    
    function printHorses(horses) {
        console.log(horses.join('->'));
        console.log(`The winner is: ${horses[horses.length - 1]}`);
        
    }
    
}
