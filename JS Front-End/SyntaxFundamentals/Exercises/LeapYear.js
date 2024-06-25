function printWhetherYearIsLeap(year) {
    if (year % 4 == 0 && year % 100 != 0) {
        console.log('yes');
    } else if (year % 400 == 0) {
        console.log('yes');
    } else {
        console.log('no');
    }
}

printWhetherYearIsLeap(1984);
printWhetherYearIsLeap(2003);
printWhetherYearIsLeap(4);