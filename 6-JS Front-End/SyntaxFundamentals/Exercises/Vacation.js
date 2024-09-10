function calculatePrice(numberOfPeople, typeOfGroup, dayOfWeek) {
    let totalPrice;
    if (typeOfGroup == 'Students') {
        if (dayOfWeek == 'Friday') {
            totalPrice = numberOfPeople * 8.45;
        } else if (dayOfWeek == 'Saturday') {
            totalPrice = numberOfPeople * 9.80;
        } else if (dayOfWeek == 'Sunday') {
            totalPrice = numberOfPeople * 10.46;
        }

        if (numberOfPeople >= 30) {
            totalPrice = totalPrice - (totalPrice * 0.15);
        }
    } else if (typeOfGroup == 'Business') {
        let currentPrice;
        if (dayOfWeek == 'Friday') {
            currentPrice = 10.90;
            totalPrice = numberOfPeople * currentPrice;
        } else if (dayOfWeek =='Saturday') {
            currentPrice = 15.60;
            totalPrice = numberOfPeople * currentPrice;
        } else if (dayOfWeek == 'Sunday') {
            currentPrice = 16;
            totalPrice = numberOfPeople * currentPrice;
        }

        if (numberOfPeople >= 100) {
            totalPrice = totalPrice - (10 * currentPrice);
        }
    } else if (typeOfGroup == 'Regular') {
        if (dayOfWeek == 'Friday') {
            totalPrice = numberOfPeople * 15;
        } else if (dayOfWeek == 'Saturday') {
            totalPrice = numberOfPeople * 20;
        } else if (dayOfWeek == 'Sunday') {
            totalPrice = numberOfPeople * 22.50;
        }

        if (numberOfPeople >= 10 && numberOfPeople <= 20 ) {
            totalPrice = totalPrice - (totalPrice * 0.05);
        }
    }

        console.log(`Total price: ${totalPrice.toFixed(2)}`);
}

calculatePrice(30, 'Students', 'Sunday');
calculatePrice(40, 'Regular', 'Saturday');