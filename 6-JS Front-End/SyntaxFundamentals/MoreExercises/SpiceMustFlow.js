function calculateTotalAmountOfSpice(startingYield) {

    let countDays = 0;
    let extractedSpices = 0;
    while (startingYield >= 100) {
        extractedSpices += (startingYield - 26);

        countDays++;
        startingYield -= 10;
    }
    if (extractedSpices >= 26) {
        extractedSpices -= 26;
    }
    

    console.log(countDays);
    console.log(extractedSpices);
}

calculateTotalAmountOfSpice(111);
calculateTotalAmountOfSpice(450);