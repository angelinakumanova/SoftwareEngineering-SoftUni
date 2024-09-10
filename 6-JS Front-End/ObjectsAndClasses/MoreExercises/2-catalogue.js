function solve(input) {
    const products = {};
    
    for (const line of input) {
        const tokens = line.split(' : ');
        const productName = tokens[0];
        const productPrice = Number(tokens[1]);
        
        products[productName] = productPrice;
    }
    
    let currentLetter = '';
    Object.entries(products)
    .sort((firstProduct, secondProduct) => firstProduct[0].localeCompare(secondProduct[0]))
    .forEach(([key, value]) => {
        const firstLetter = key.charAt(0);
        if (firstLetter !== currentLetter) {
            currentLetter = firstLetter;
            console.log(currentLetter);
        }
        
        console.log(`   ${key}: ${value}`);
    });
}
    
    solve([
        'Appricot : 20.4',
        'Fridge : 1500',
        'TV : 1499',
        'Deodorant : 10',
        'Boiler : 300',
        'Apple : 1.25',
        'Anti-Bug Spray : 15',
        'T-Shirt : 10'
    ]);
    