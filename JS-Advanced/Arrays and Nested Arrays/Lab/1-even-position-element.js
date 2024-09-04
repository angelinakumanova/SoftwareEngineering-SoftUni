function solve(array) {
    const evenElements = array.filter((_, index) => index % 2 === 0).join(' ');

    console.log(evenElements);
    
}

solve(['20', '30', '40', '50', '60']);
