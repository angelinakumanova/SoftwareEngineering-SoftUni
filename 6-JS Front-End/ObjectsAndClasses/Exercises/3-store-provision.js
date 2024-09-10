function solve(currentStock, orderedProducts) {
    const allProducts = {};

    for (let i = 0; i < currentStock.length - 1; i++) {
        const product = currentStock[i];
        const quantity = Number(currentStock[i + 1]);
        allProducts[product] = quantity;
        i++;
    }

    for (let i = 0; i < orderedProducts.length - 1; i++) {
        const product = orderedProducts[i];
        const quantity = Number(orderedProducts[i + 1]);

        if (allProducts.hasOwnProperty(product)) {
            allProducts[product] += quantity;
        } else {
            allProducts[product] = quantity;
        }
        i++;
    }

    for(const [key, value] of Object.entries(allProducts)) {
        console.log(`${key} -> ${value}`);
    }
}

solve([
    'Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'
    ],
    [
    'Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30'
    ]
    );
