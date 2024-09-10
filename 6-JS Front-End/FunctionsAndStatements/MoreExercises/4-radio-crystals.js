function solve(oreInfo) {
    const desiredThickness = oreInfo[0];
    
    for(let i = 1; i < oreInfo.length; i++) {
        console.log(`Processing chunk ${oreInfo[i]} microns`);
        operate(oreInfo[i], desiredThickness);
    }
    
    
    function operate(oreThickness, desiredThickness) {
        
        const operations = new Map([
            ['Cut', a => a / 4],
            ['Lap', a => a * 0.8],
            ['Grind', a => a - 20],
            ['Etch', a => a - 2],
        ]);
        
        for (let [key, value] of operations) {
            let count = 0;
            const limit = key === 'Etch' ? desiredThickness - 1 : desiredThickness;

            while (value(oreThickness) >= limit) {
                oreThickness = value(oreThickness);
                count++;
            }
            
            if (count > 0) {
                console.log(`${key} x${count}`);
                oreThickness = transport(oreThickness);
            }
            
            
            
            if (oreThickness === desiredThickness) {
                break;
            }
            
        }
        
        if (oreThickness < desiredThickness) {
            oreThickness = oreThickness + 1;
            console.log('X-ray x1');
        }
        
        console.log(`Finished crystal ${desiredThickness} microns`);
    }
    
    function transport(oreThickness) {
        console.log('Transporting and washing');
        
        return Math.floor(oreThickness);
    }

}

solve([100, 396]);
