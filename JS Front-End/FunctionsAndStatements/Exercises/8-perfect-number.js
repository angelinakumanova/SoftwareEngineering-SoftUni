function checkIfNumberIsPerfect(number) {
    let divisors = [];
    let halfOfNumber = number / 2;

    for (let i = 1; i <= halfOfNumber; i++) {
        if (number % i === 0 ) {
            divisors.push(i);
        }
    }

    let sumOfDivisors = divisors.reduce((a,b) => a + b, 0);

    if (sumOfDivisors === number) {
        console.log('We have a perfect number!')
    } else {
        console.log('It\'s not so perfect.');
    }
}

checkIfNumberIsPerfect(6);
checkIfNumberIsPerfect(28);
checkIfNumberIsPerfect(1236498);
