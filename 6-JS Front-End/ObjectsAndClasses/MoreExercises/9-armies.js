function solve(input) {
    /*"{leader} arrives" – add the leader (no army)
    "{leader}: {army name}, {army count}" – add the army with its count to the leader (if he exists)
    "{army name} + {army count}" – if the army exists somewhere add the count
    "{leader} defeated" – delete the leader and his army (if he exists) */
    const leaders = {};
    
    for (const line of input) {
        
        if (line.includes('arrives')) {
            const indexOfArrives = line.indexOf('arrives');
            const leaderName = line.substring(0, indexOfArrives - 1);
            leaders[leaderName] = [];
            
        } else if (line.includes('+')) {
            const tokens = line.split(' + ');
            const armyName = tokens[0];
            const armyCount = Number(tokens[1]);
            
            addCountToArmyIfFound(armyName, armyCount);
            
        } else if (line.includes('defeated')) {
            const leaderName = line.split(' ')[0];
            
            if (leaders.hasOwnProperty(leaderName)) {
                delete leaders[leaderName]
            }
            
        } else {
            const tokens = line.split(': ');
            const leaderName = tokens[0];
            const armyInfo = tokens[1].split(', ');
            const armyName = armyInfo[0];
            const armyCount = Number(armyInfo[1]);
            
            if (leaders.hasOwnProperty(leaderName)) {
                const army = {};
                army.name = armyName;
                army.count = armyCount;
                
                leaders[leaderName].push(army);
            }
        }
    }
    
    /*"{leader one name}: {total army count}
    >>> {armyOne name} - {army count}
    >>> {armyTwo name} - {army count} */
    
    Object.entries(leaders).sort(([ , firstArmies], [ , secondArmies]) => {
        const firstArmiesTotalCount = firstArmies.reduce((acc, army) => acc + army.count, 0);
        const secondArmiesTotalCount = secondArmies.reduce((acc, army) => acc + army.count, 0);
    
        return secondArmiesTotalCount - firstArmiesTotalCount;
    }).forEach(([leader, armies]) => {
        const armiesTotalCount = armies.reduce((acc, army) => acc + army.count, 0);

        console.log(`${leader}: ${armiesTotalCount}`);

        const sortedArmies = armies.sort((firstArmy, secondArmy) => {
            return secondArmy.count - firstArmy.count;
        });

        for (const army of sortedArmies) {
            console.log(`>>> ${army.name} - ${army.count}`);
        }
    });
    
    
    
    
    
    function addCountToArmyIfFound(armyName, armyCount) {
        for (const leader in leaders) {
        const armies = leaders[leader];
    
        for (const army of armies) {
            if (armyName === army.name) {
            army.count += armyCount;
            }
            }
        }
    }
    
}

solve(['Rick Burr arrives', 'Fergus: Wexamp, 30245', 'Rick Burr: Juard, 50000', 'Findlay arrives', 'Findlay: Britox, 34540', 'Wexamp + 6000', 'Juard + 1350', 'Britox + 4500', 'Porter arrives', 'Porter: Legion, 55000', 'Legion + 302', 'Rick Burr defeated', 'Porter: Retix, 3205']);
console.log(' ');
solve(['Rick Burr arrives', 'Findlay arrives', 'Rick Burr: Juard, 1500', 'Wexamp arrives', 'Findlay: Wexamp, 34540', 'Wexamp + 340', 'Wexamp: Britox, 1155', 'Wexamp: Juard, 43423']);
