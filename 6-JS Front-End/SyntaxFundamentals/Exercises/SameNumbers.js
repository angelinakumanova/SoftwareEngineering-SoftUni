function printInfo(number) {
    let digits = String(number).split('');
    
    let isSame = true;
    let sum = Number(digits[0]);
    for(let i = 1; i < digits.length; i++) {
        let lastNumber = Number(digits[i - 1]);

        if (isSame != false) {
            if (lastNumber == digits[i]) {
                isSame = true;
            } else {
                isSame = false;
            }
        }

        sum += Number(digits[i]);
    }

    console.log(isSame);
    console.log(sum);
}

printInfo(2222222);
printInfo(1234);
printInfo(1);