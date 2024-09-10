function solve(numbers) {
    let evenSum = numbers.filter((element) => element % 2 == 0).reduce(add, 0);
    let oddSum = numbers.filter((element) => element % 2 != 0).reduce(add, 0);

    console.log(evenSum - oddSum);

    function add (firstNum, secondNum) { return firstNum + secondNum};
}

solve([1,2,3,4,5,6]);
solve([3,5,7,9]);
solve([2,4,6,8,10]);