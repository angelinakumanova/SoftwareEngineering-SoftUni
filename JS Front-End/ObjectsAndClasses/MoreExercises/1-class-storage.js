class Storage {

    constructor(capacity) {
        this.capacity = capacity;
        this.storage = [];
    }

    addProduct(product) {
        this.storage.push(product);
        this.capacity -= product.quantity;
    }

    getProducts() {
        let output = '';
        this.storage.forEach(product => {
            output += `${JSON.stringify(product)}\n`;
        });

        return output.trim();
    }

    get totalCost() {
        let totalCost = 0;
        this.storage.forEach(product => {
            totalCost += (product.price * product.quantity);
        });

        return totalCost;
    }
    
}

let productOne = {name: 'Cucamber', price: 1.50, quantity: 15};
let productTwo = {name: 'Tomato', price: 0.90, quantity: 25};
let productThree = {name: 'Bread', price: 1.10, quantity: 8};
let storage = new Storage(50);
storage.addProduct(productOne);
storage.addProduct(productTwo);
storage.addProduct(productThree);
console.log(storage.getProducts());
console.log(storage.capacity);
console.log(storage.totalCost);
