function solve(...numbers) {
    const largestNumber = numbers.reduce((prevNum, currentNum) => prevNum > currentNum ? prevNum : currentNum);

    console.log(`The largest number is ${largestNumber}.`);
}

solve(5, -3, 16);
