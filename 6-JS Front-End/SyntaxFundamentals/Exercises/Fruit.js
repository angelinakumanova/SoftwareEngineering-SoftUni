function calculatePrice(fruit, weightInGrams, pricePerKG) {
    let weightInKG = weightInGrams / 1000;
    let totalPrice = weightInKG * pricePerKG;
    
    console.log(`I need $${totalPrice.toFixed(2)} to buy ${weightInKG.toFixed(2)} kilograms ${fruit}`);
}

calculatePrice('orange', 2500, 1.80);
calculatePrice('apple', 1563, 2.35);