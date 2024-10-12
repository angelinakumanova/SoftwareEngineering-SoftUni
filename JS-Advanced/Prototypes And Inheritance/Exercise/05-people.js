class Employee {
    constructor (name, age) {
        this.name = name;
        this.age = age;
        this._salary = 0;
    }

    work() {
    }

    collectSalary() {
        return `${this.name} received ${this._salary} this month.`;
    }

    set salary(value) {
        this._salary = value;
    }

}

class Junior extends Employee {
    constructor(name, age) {
        super(name, age);
    }

    work() {
        return `${this.name} is working on a simple task.`;
    }
}

class Senior extends Employee {
    #currentTaskCount = 0;

    constructor(name, age) {
        super(name, age);
    }

    work() {
        const tasks = [
            `${this.name} is working on a complicated task.`,
            `${this.name} is taking time off work.`,
            `${this.name} is supervising junior workers.`
        ];

        const currentTask = tasks[this.#currentTaskCount++];

        if (this.#currentTaskCount === tasks.length) {
            this.#currentTaskCount = 0;
        }

        return currentTask;
    }
}


class Manager extends Employee {
    #currentTaskCount = 0;

    constructor(name, age) {
        super(name, age);
        this._dividend = 0;
    }

    work() {
        const tasks = [
            `${this.name} scheduled a meeting.`,
            `${this.name} is preparing a quarterly report.`
        ];

        const currentTask = tasks[this.#currentTaskCount++];

        if (this.#currentTaskCount === tasks.length) {
            this.#currentTaskCount = 0;
        }

        return currentTask;
    }

    collectSalary() {
        return `${this.name} received ${this._salary + this._dividend} this month.`;
    }

    set dividend(value) {
        this._dividend = value;
    } 
}


const junior = new Junior('Ivan',25); 
 
console.log(junior.work());
console.log(junior.work());
 
junior.salary = 5811; 
console.log(junior.collectSalary());  

const senior = new Senior('Alex', 31); 
 
console.log(senior.work());
console.log(senior.work());
console.log(senior.work());
console.log(senior.work());
 
senior.salary = 12050; 
console.log(senior.collectSalary()); 

const manager = new Manager('Tom', 55); 
 
manager.salary = 15000; 
console.log(manager.collectSalary());
manager.dividend = 2500; 
console.log(manager.collectSalary());

console.log(manager.work());
console.log(manager.work());
console.log(manager.work());

