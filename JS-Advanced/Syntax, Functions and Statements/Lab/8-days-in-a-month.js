function solve(month, year) {
    let days;

    if (month === 2) { 
        if ((year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0)) {
            days = 29; 
        } else {
            days = 28; 
        }
    } else if (month === 4 || month === 6 || month === 9 || month === 11) {
        days = 30;
    } else {
        days = 31; 
    }

    console.log(days);
}

solve(2, 2021);
