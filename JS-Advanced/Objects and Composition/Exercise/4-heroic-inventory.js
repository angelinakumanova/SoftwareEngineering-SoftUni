function createRegisterOfHeroes(heroes) {
    const register = [];
    
    for (const hero of heroes) {
        if (hero.trim() !== '') {
            const [name, level, allItems] = hero.split(' / ');
            
            const items = allItems ? allItems.split(', ') : [];
            register.push({
                name,
                'level': Number(level),
                items,
            });
        }
    }
    
    
    
    console.log(JSON.stringify(register));
    
}

createRegisterOfHeroes(['Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara']);
    