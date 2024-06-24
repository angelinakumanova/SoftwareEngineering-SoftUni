function calculateArea(input) {
    let type = typeof(input);
    let result;
    if (type === 'number') {
        result = Math.pow(input, 2) * Math.PI;
        console.log(result.toFixed(2));
    } else {
        console.log(`We cannot calculate the circle area, because we receive a ${type}.`);
    }
}

calculateArea(5);
calculateArea('name');