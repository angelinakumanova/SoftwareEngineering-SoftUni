function solve(array, number) {
    const newArr = [];
    array.forEach((element, idx) => {
        if (idx % number === 0) {
            newArr.push(element);
        }
    })
    return newArr;
}

solve(['5', '20', '31', '4', '20'], 2);
solve(['dsa','asd', 'test', 'tset'], 2);
solve(['1', '2','3', '4', '5'], 6);