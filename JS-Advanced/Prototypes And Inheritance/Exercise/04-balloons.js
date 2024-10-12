class Balloon {
    constructor(color, gasWeight) {
        this.color = color;
        this.gasWeight = gasWeight;
    }
}

class PartyBalloon extends Balloon {
    constructor(color, gasWeight, ribbonColor, ribbonLength) {
        super(color, gasWeight);
        this._ribbon = {       
            color: ribbonColor,
            length: ribbonLength
        };
    }

    get ribbon() {
        return this._ribbon;
    }
    
}

class BirthdayBalloon extends PartyBalloon {
    constructor(color, gasWeight, ribbonColor, ribbonLength, text) {
        super(color, gasWeight, ribbonColor, ribbonLength); 
        this._text = text; 
    }

    // Text getter
    get text() {
        return this._text;  
    }
}

let testBalloon = new Balloon("yellow", 20.5);
let testPartyBalloon = new PartyBalloon("yellow", 20.5, "red", 10.25);
let ribbon = testPartyBalloon.ribbon;
let testBirthdayBalloon = new BirthdayBalloon('red', 20.5, 'white', 10.25, 'Happy Birthday');
console.log(testBalloon);
console.log(testPartyBalloon);
console.log(ribbon);
console.log(testBirthdayBalloon);

