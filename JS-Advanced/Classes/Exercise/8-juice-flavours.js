function solve(juicesArray) {
    const juicesMap = new Map();
    const bottlesMap = new Map();

    for (const juice of juicesArray) {
        const[juiceName, quantity] = juice.split(' => ');

        juicesMap.set(juiceName, (juicesMap.get(juiceName) || 0) + Number(quantity));

        const currentQuantity = juicesMap.get(juiceName);
        if (currentQuantity >= 1000) {
            const bottles = Math.floor(currentQuantity / 1000);
            const leftJuice = currentQuantity % 1000;

            bottlesMap.set(juiceName, (bottlesMap.get(juiceName) || 0) + bottles);
            juicesMap.set(juiceName, leftJuice); 
        }
    }

    for (const [juiceName, bottleCount] of bottlesMap) {
        console.log(`${juiceName} => ${bottleCount}`);
    }
}

solve(['Orange => 2000',
    'Peach => 1432',
    'Banana => 450',
    'Peach => 600',
    'Strawberry => 549']);
console.log();
solve(['Kiwi => 234',
    'Pear => 2345',
    'Watermelon => 3456',
    'Kiwi => 4567',
    'Pear => 5678',
    'Watermelon => 6789']);
