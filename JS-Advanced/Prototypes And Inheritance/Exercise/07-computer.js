class Keyboard {
    constructor(manufacturer, responseTime) {
        this.manufacturer = manufacturer;
        this.responseTime = responseTime;
    }
}

class Monitor {
    constructor(manufacturer, width, height) {
        this.manufacturer = manufacturer;
        this.width = width;
        this.height = height;
    }
}

class Battery {
    constructor(manufacturer, expectedLife) {
        this.manufacturer = manufacturer;
        this.expectedLife = expectedLife;
    }
}

class Computer {
    constructor(manufacturer, processorSpeed, ram, hardDiskSpace) {
        if (new.target === Computer) {
            throw new Error('Cannot instantiate abstract class Computer directly.');
        }

        this.manufacturer = manufacturer;
        this.processorSpeed = processorSpeed;
        this.ram = ram;
        this.hardDiskSpace = hardDiskSpace;
    }
}

class Laptop extends Computer {
    constructor(manufacturer, processorSpeed, ram, hardDiskSpace, weight, color, battery) {
        super(manufacturer, processorSpeed, ram, hardDiskSpace);
        this.weight = weight;
        this.color = color;
        this.battery = battery;
    }

    get battery() {
        return this._battery;
    }

    set battery(value) {
        if (!(value instanceof Battery)) {
            throw new TypeError('Passed argument is not a Battery instance.');
        }
        this._battery = value;
    }
}

class Desktop extends Computer {
    constructor(manufacturer, processorSpeed, ram, hardDiskSpace, keyboard, monitor) {
        super(manufacturer, processorSpeed, ram, hardDiskSpace);
        this.keyboard = keyboard;
        this.monitor = monitor;  
    }

    get keyboard() {
        return this._keyboard;
    }

    set keyboard(value) {
        if (!(value instanceof Keyboard)) {
            throw new TypeError('Passed argument is not a Keyboard instance.');
        }
        this._keyboard = value;
    }

    get monitor() {
        return this._monitor;
    }

    set monitor(value) {
        if (!(value instanceof Monitor)) {
            throw new TypeError('Passed argument is not a Monitor instance.');
        }
        this._monitor = value;
    }
}

let battery = new Battery('Energy', 3);
console.log(battery);
let laptop = new Laptop("Hewlett Packard", 2.4, 4, 0.5, 3.12, "Silver", battery);
console.log(laptop);
