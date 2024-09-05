function factory(library, orders) {
    const products = [];

    for (const order of orders) {
        const object = order.template;
        const functions = order.parts;

        for (const func of functions) {
            object[func] = library[func];
        }

        products.push(object);
    }

    return products;
}

const library = {
    print: function () {
        console.log(`${this.name} is printing a page`);
    },
    scan: function () {
        console.log(`${this.name} is scanning a document`);
    },
    play: function (artist, track) {
        console.log(`${this.name} is playing '${track}' by ${artist}`);
    },
};
const orders = [
    {
        template: { name: 'ACME Printer'},
        parts: ['print']      
    },
    {
        template: { name: 'Initech Scanner'},
        parts: ['scan']      
    },
    {
        template: { name: 'ComTron Copier'},
        parts: ['scan', 'print']      
    },
    {
        template: { name: 'BoomBox Stereo'},
        parts: ['play']      
    }
];
const products = factory(library, orders);
console.log(products);
