function solve(array) {
    const modifiedArray = array.reduce((arr, element) => {
        if (element >= 0) {
            arr.push(element);
        } else {
            arr.unshift(element);
        }
        return arr;
    }, []);

    modifiedArray.forEach(el => console.log(el));
}

solve([7, -2, 8, 9]);

