function calculateTotalPrice(product, quantity) {
    
    switch(product) {
        case 'coffee':
        console.log((1.50 * quantity).toFixed(2));
        break;
        case 'water':
        console.log((1.00 * quantity).toFixed(2));
        break;
        case 'coke':
        console.log((1.40 * quantity).toFixed(2));
        break;
        case 'snacks':
        console.log((2.00 * quantity).toFixed(2));
        break;
    }
}

calculateTotalPrice('water', 5);
calculateTotalPrice('coffee', 2);
