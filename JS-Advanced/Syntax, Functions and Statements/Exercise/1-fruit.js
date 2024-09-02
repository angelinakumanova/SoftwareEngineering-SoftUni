function solve(fruit, grams, pricePerKg) {
    const weightInKg = grams / 1000;
    const totalPrice = weightInKg * pricePerKg;

    console.log(`I need $${totalPrice.toFixed(2)} to buy ${weightInKg.toFixed(2)} kilograms ${fruit}.`);
    
}

solve('orange', 2500, 1.80);
