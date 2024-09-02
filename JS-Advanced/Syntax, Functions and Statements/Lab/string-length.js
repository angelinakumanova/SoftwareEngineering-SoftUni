function solve(firstString, secondString, thirdString) {
    const firstStringLength = firstString.length;
    const secondStringLength = secondString.length;
    const thirdStringLength = thirdString.length;

    const sum = firstStringLength + secondStringLength + thirdStringLength;
    const averageResult = Math.floor(sum / 3);

    console.log(sum);
    console.log(averageResult);
}

solve('chocolate', 'ice cream', 'cake');
