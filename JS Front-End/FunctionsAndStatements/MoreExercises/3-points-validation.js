function validatePoints(points) {
    const x1 = points[0];
    const y1 = points[1];
    const x2 = points[2];
    const y2 = points[3];
    
    printDistanceValidity(x1, y1, 0, 0);
    printDistanceValidity(x2, y2, 0, 0);
    printDistanceValidity(x1, y1, x2, y2);


    function calculateDistance(x1, y1, x2, y2) {
        const firstSubtraction = Math.pow((x2 - x1), 2);
        const secondSubtraction = Math.pow((y2 - y1), 2);

        const distance = Math.sqrt((firstSubtraction + secondSubtraction));

        return distance;
    }

    function printDistanceValidity(x1, y1, x2, y2) {
        const distance = calculateDistance(x1, y1, x2, y2);
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is ${Number.isInteger(distance) ? 'valid' : 'invalid'}`);
    }
}

validatePoints([3, 0, 0, 4]);
validatePoints([2, 1, 1, 1]);
