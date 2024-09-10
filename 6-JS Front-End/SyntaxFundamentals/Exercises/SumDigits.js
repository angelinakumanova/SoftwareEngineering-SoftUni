function sumDigits(number) {
    let digits = String(number).split('');

    let totalSum = 0;
    for (let i = 0; i < digits.length; i++) {
        totalSum += Number(digits[i]);
    }

    console.log(totalSum);
}

sumDigits(245678);
sumDigits(97561);
sumDigits(543);