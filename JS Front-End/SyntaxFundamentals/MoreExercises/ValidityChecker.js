function printValidityOfDistance(x1, y1, x2, y2) {
    let firstDistance = calculateDistance(x1, y1, 0, 0);
    let secondDistance = calculateDistance(x2, y2, 0, 0);
    let thirdDistance = calculateDistance(x1, y1, x2, y2);
    

    function calculateDistance(x1, y1, x2, y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));


    }

    function checkValidity(distance, x1, y1, x2, y2) {
        if (Number.isInteger(distance)) {
            console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`);
        } else {
            console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`);
        }  
    }

    checkValidity(firstDistance, x1, y1, 0, 0);
    checkValidity(secondDistance, x2, y2, 0, 0);
    checkValidity(thirdDistance, x1, y1, x2, y2);
}

printValidityOfDistance(3, 0, 0, 4);
printValidityOfDistance(2, 1, 1, 1);