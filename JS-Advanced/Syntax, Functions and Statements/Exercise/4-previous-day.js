function solve(year, month, day) {
    const date = new Date(year, month - 1, day);

    date.setDate(date.getDate() - 1);

    const previousDay = date.getDate();
    const updatedMonth = date.getMonth() + 1;
    const updatedYear = date.getFullYear();
    
    
    console.log(`${updatedYear}-${updatedMonth}-${previousDay}`);
    
}

solve(2016, 9, 30);
solve(2016, 1, 1);
