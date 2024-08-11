function solve([allowedCharacters, ...rest]) {
    const characters = (rest.slice(0, allowedCharacters)).map(character => {
        const tokens = character.split(' ');
        const name = tokens[0];
        const health = Number(tokens[1]);
        const bullets = Number(tokens[2]);
        
        return {
            name,
            health,
            bullets,
        };
    });
    
    const commands = rest.slice(allowedCharacters);
    
    for (const command of commands) {
        
        if (command === 'Ride Off Into Sunset') {
            break;
        }
        const tokens = command.split(' - ');
        const name = tokens[1];
        const hero = characters.find(character => character.name === name);
        
        const cmnd = tokens[0];
        if (cmnd === 'FireShot') {
            const target = tokens[2];
            
            fireShot(hero, target);
        } else if (cmnd === 'TakeHit') {
            const damage = Number(tokens[2]);
            const attacker = tokens[3];
            
            takeHit(hero, damage, attacker);
        } else if (cmnd === 'Reload') {
            reload(hero);
        } else if (cmnd === 'PatchUp') {
            const amount = Number(tokens[2]);
            
            patchUp(hero, amount);
        }
        
    }
    
    characters.forEach(character => {
        console.log(character.name);
        console.log(` HP: ${character.health}`);
        console.log(` Bullets: ${character.bullets}`);
    });
    
    
    function fireShot(hero, target) {
        const heroName = hero.name;
        const heroBullets = hero.bullets;
        
        if (heroBullets > 0) {
            hero.bullets -= 1;
            console.log(`${heroName} has successfully hit ${target} and now has ${hero.bullets} bullets!`);
            return;
        }
        
        console.log(`${heroName} doesn't have enough bullets to shoot at ${target}!`);
    }
    
    function takeHit(hero, damage, attacker) {
        const name = hero.name;
        
        hero.health -= damage;
        
        if (hero.health > 0) {
            console.log(`${name} took a hit for ${damage} HP from ${attacker} and now has ${hero.health} HP!`)
            return;
        }
        
        console.log(`${name} was gunned down by ${attacker}!`)
        removeHero(hero);
    }
    
    function reload(hero) {
        const name = hero.name;
        const currentBullets = hero.bullets;
        
        if (currentBullets === 6) {
            console.log(`${name}'s pistol is fully loaded!`);
            return;
        }
        
        hero.bullets = 6;
        console.log(`${name} reloaded ${6 - currentBullets} bullets!`);
    }
    
    function patchUp(hero, amount) {
        const name = hero.name;
        const currentHealth = hero.health;
        
        if (currentHealth === 100) {
            console.log(`${name} is in full health!`)
            return;
        }
        
        const updatedHealth = Math.min(currentHealth + amount, 100);
        hero.health = updatedHealth;
        console.log(`${name} patched up and recovered ${updatedHealth - currentHealth} HP!`);
    }
    
    function removeHero(hero) {
        const indexOfHero = characters.indexOf(hero);
        characters.splice(indexOfHero, 1);
    }
}

solve((["2",
    "Jesse 100 4",
    "Walt 100 5",
    "FireShot - Jesse - Bandit",
     "TakeHit - Walt - 30 - Bandit",
     "PatchUp - Walt - 20" ,
     "Reload - Jesse",
     "Ride Off Into Sunset"])
    );
    