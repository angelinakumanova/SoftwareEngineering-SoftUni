function sumOddAndEven(number) {
    number = String(number);

    let oddDigitsSum = number.split('').filter((digit) => digit % 2 != 0).map(Number).reduce((a, b) => a + b, 0);
    let evenDigitsSum = number.split('').filter((digit) => digit % 2 === 0).map(Number).reduce((a, b) => a + b, 0);

    console.log(`Odd sum = ${oddDigitsSum}, Even sum = ${evenDigitsSum}`);
}

sumOddAndEven(1000435);
