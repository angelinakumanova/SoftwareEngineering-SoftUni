function cook(number, ...operations) {
    number = Number(number);

    for(let i = 0; i < operations.length; i++) {
        number = doOperation(operations[i], number);
        console.log(number);
        
    }


    function doOperation(operation, number) {
        if (operation == 'chop') {
            return number / 2;
        } else if (operation == 'dice') {
            return Math.sqrt(number);
        } else if (operation == 'spice') {
            return number + 1;
        } else if (operation == 'bake') {
            return number * 3;
        } else if (operation == 'fillet') {
            return number - (number * 0.2);
        }
    }
}

cook('32', 'chop', 'chop', 'chop', 'chop', 'chop');
cook('9', 'dice', 'spice', 'chop', 'bake', 'fillet');