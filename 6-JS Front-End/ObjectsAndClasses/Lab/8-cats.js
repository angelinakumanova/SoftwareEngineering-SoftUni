function solve(input) {

    let cats = [];

    class Cat {
        constructor(name, age) {
            this.name = name;
            this.age = age;
        }

        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`);
        }
    }

    for (const line of input) {
        const tokens = line.split(' ');
        const name = tokens[0];
        const age = tokens[1];

        const cat = new Cat(name, age);
        cats.push(cat);
    }

    for (const cat of cats) {
        cat.meow();
    }

    
}

solve(['Mellow 2', 'Tom 5']);
