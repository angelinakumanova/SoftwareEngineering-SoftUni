class Figure {
    constructor() {
        this._units = 'cm';
    }

    get units() {
        return this._units;
    }

    get area() {

    }


    changeUnits(newUnits) {
        this._units = newUnits;
    }

    toString() {
        return `Figures units: ${this._units}`;
    }
}

class Circle extends Figure {
    constructor(radius) {
        super();
        this.radius = radius;
    }

    get area() {
        let areaInCm = Math.PI * this.radius * this.radius; 
        switch (this.units) {
          case 'm':
            return areaInCm / 10000; 
          case 'mm':
            return areaInCm * 100; 
          default:
            return areaInCm; 
        }
      }
    
      toString() {
        return `Figures units: ${this.units}, Area: ${this.area.toFixed(2)} ${this.units}, Radius: ${this.radius}`;
      }
}

class Rectangle extends Figure {
    constructor(width, height, units) {
        super();
        this.width = width;
        this.height = height;
        this.changeUnits(units);
    }

    get area() {
        let areaInCm = this.width * this.height; 
        switch (this.units) {
          case 'm':
            return areaInCm / 10000; 
          case 'mm':
            return areaInCm * 100; 
          default:
            return areaInCm;
        }
    }

    toString() {
        return `Figures units: ${this.units}, Area: ${this.area.toFixed(2)} ${this.units}, Width: ${this.width}, Height: ${this.height}`;
      }
}



let c = new Circle(5);
console.log(c.area); // 78.53981633974483
console.log(c.toString()); // Figures units: cm Area: 78.53981633974483 - radius: 5

let r = new Rectangle(3, 4, 'mm');
console.log(r.area); // 1200 
console.log(r.toString()); //Figures units: mm Area: 1200 - width: 30, height: 40

r.changeUnits('cm');
console.log(r.area); // 12
console.log(r.toString()); // Figures units: cm Area: 12 - width: 3, height: 4

c.changeUnits('mm');
console.log(c.area); // 7853.981633974483
console.log(c.toString()) // Figures units: mm Area: 7853.981633974483 - radius: 5
