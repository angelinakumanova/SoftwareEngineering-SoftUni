function modifyNumber(number) {
    number = String(number);
    while (calculateAverage(number) < 5) {
        number += '9';
    }


    console.log(number);

    function calculateAverage(number) {
        const sum = number.split('').map(Number).reduce((a,b) => a + b, 0);

        return sum / String(number).length;;
    }
}

modifyNumber(101);
modifyNumber(5835);
