function checkIfIntegerIsPalindrome(numbers) {
    for (let number of numbers) {
        let reversedNumber = Number(String(number).split('').reverse().join(''));

        console.log(reversedNumber === number ? 'true' : 'false');
    }
}

checkIfIntegerIsPalindrome([123,323,421,121]);
checkIfIntegerIsPalindrome([32,2,232,1010]);
