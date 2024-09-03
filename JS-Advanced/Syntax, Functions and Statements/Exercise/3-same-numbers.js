function solve(number) {
    const digits = String(number).split('');

    const isSameNumbers = digits.every(digit => digit === digits[0]);

    const sum = digits.reduce((prevValue, currentValue) => prevValue + Number(currentValue), 0);

    console.log(isSameNumbers);
    console.log(sum);
    
}

solve(2222222);

