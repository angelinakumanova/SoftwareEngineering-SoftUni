function solve(array, firstParam, secondParam) {
    const firstParamIndex = array.indexOf(firstParam);
    const secondParamIndex = array.indexOf(secondParam);

    const newArr = array.slice(firstParamIndex, secondParamIndex + 1);

    return newArr;
}

console.log(solve(['Pumpkin Pie',
    'Key Lime Pie',
    'Cherry Pie',
    'Lemon Meringue Pie',
    'Sugar Cream Pie'],
   'Key Lime Pie',
   'Lemon Meringue Pie'));
