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

function printDeckOfCards(deck) {
    const cards = [];

    for (const card of deck) {
        const face = card.slice(0, -1);
        const suit = card.slice(-1);

        try {
            const cardObject = createCard(face, suit);
            cards.push(cardObject.toString());
        } catch (error) {
            console.log(`Invalid card: ${card}`);
            return;
        }
    }

    console.log(cards.join(' '));
}

printDeckOfCards(['AS', '10D', 'KH', '2C']);
printDeckOfCards(['5S', '3D', 'QD', '1C']);
