function solve(input) {
    const heroes = [];

    for (const line of input) {
        const [heroName, level, ...items] = line.split(' / ');
        const hero = {
            heroName,
            level: Number(level),
            items,
        }

        heroes.push(hero);
    }

    const sortedHeroes = heroes.sort((hero1, hero2) => hero1.level - hero2.level).forEach(hero => {
        console.log(`Hero: ${hero.heroName}`);
        console.log(`level => ${hero.level}`);
        console.log(`items => ${hero.items.join(', ')}`);
    });
    

}

solve([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
    ]
    );
