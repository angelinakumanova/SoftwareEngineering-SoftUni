function createCard(cardFace, cardSuit) {
    const faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];

    const suits = {
        'S': '\u2660',
        'H': '\u2665',
        'D': '\u2666',
        'C': '\u2663'
    };

    if (!faces.includes(cardFace)) {
        throw new Error(`Invalid card face: ${cardFace}`);
    }

    if (!suits.hasOwnProperty(cardSuit)) {
        throw new Error(`Invalid card suit: ${cardSuit}`);
    }

    const card = {
        face: cardFace,
        suit: suits[cardSuit],
        toString() {
            return this.face + this.suit;
        },
    };

    return card;
}

try {
    const card = createCard('1', 'C'); 
    console.log(card.toString());
} catch (error) {
    console.error(error.message);
}

try {
    const card = createCard('10', 'H'); 
    console.log(card.toString());
} catch (error) {
    console.error(error.message);
}



