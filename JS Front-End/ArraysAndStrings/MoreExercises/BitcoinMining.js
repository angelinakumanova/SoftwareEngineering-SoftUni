function solve(goldDugInfo) {
    const bitcoinValue = 11949.16;

    let countDays = 0;
    let totalMoney = 0;
    let boughtBitcoins = 0;
    let firstBitcoinBoughtDay = 0;

    for (let gold of goldDugInfo) {
        countDays++;
        if (countDays % 3 === 0) {
            gold = gold * 0.70;
        }

        let currentMoneyMade = gold * 67.51;
        totalMoney += currentMoneyMade;

        while (totalMoney >= bitcoinValue) {
            totalMoney -= bitcoinValue;
            if (firstBitcoinBoughtDay === 0) {
                firstBitcoinBoughtDay = countDays;
            }
            boughtBitcoins++;
        }
    }

    console.log(`Bought bitcoins: ${boughtBitcoins}`);
    if (boughtBitcoins >= 1) {
        console.log(`Day of the first purchased bitcoin: ${firstBitcoinBoughtDay}`);
    }
    console.log(`Left money: ${totalMoney.toFixed(2)} lv.`)
}

solve([100, 200, 300]);
solve([50, 100]);
solve([3124.15, 504.212, 2511.124]);