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
            while (value(oreThickness) >= desiredThickness - 1) {
                oreThickness = value(oreThickness);
                count++;
            }

            console.log(`${key} x${count}`);
            oreThickness = transport(oreThickness);

            if (oreThickness === desiredThickness) {
                console.log(`Finished crystal ${desiredThickness} microns`);
                break;
            }
        }

        doXrayOnCrystal(oreThickness, desiredThickness);
    }

    function transport(oreThickness) {
        console.log('Transporting and washing');

        return Math.floor(oreThickness);
    }

    function doXrayOnCrystal(oreThickness, desiredThickness) {
        if (oreThickness + 1 === desiredThickness) {
            console.log('X-ray x1');
            console.log(`Finished crystal ${desiredThickness} microns`);
        }
    }
}

solve([1375, 50000]);
// solve([1000, 4000, 8100]);
