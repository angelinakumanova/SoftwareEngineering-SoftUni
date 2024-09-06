function printInAlphabeticalOrder(input) {
    const elements = [];

    for (const iterator of input) {
        const [name, price] = iterator.split(' : ');

        elements.push({name, price});
    }

    let currentGroupLetter;
    elements.sort((firstEl, secondEl) => firstEl.name.localeCompare(secondEl.name)).forEach(el => {
        const name = el.name;
        const firstLetter = name.charAt(0);
        const price = el.price;

        if (currentGroupLetter != firstLetter) {
            currentGroupLetter = firstLetter;
            console.log(currentGroupLetter);
        }

        console.log(`  ${name}: ${price}`);
    });
}

printInAlphabeticalOrder(['Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10']);
