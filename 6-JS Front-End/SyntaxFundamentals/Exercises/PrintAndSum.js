function sumInterval(firstNumber, secondNumber) {
    let sum = 0;
    let allNumbers = '';
    for(let i = firstNumber; i <= secondNumber; i++) {
        sum += i;
        allNumbers += i + ' ';
    }

    console.log(allNumbers);
    console.log(`Sum: ${sum}`);
}

sumInterval(5, 10);
sumInterval(0, 26);
sumInterval(50, 60);