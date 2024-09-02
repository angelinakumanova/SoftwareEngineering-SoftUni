function solve(input) {    
    if (typeof input != 'number') {
        console.log(`We can not calculate the circle area, because we receive a ${typeof input}.`);
        return;
    }

    const circleArea = Math.PI * input ** 2;

    console.log(circleArea.toFixed(2));
}

solve(5);
solve('name');
