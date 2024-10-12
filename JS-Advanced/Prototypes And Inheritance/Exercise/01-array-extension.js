Array.prototype.last = function() {
    if (this.length > 0) {
        return this[this.length - 1];
    }

    return undefined;
}

Array.prototype.skip = function(n) {
    if (n >= 0) {
        return this.slice(n);
    }

    throw Error('N should be a positive number');
}

Array.prototype.take = function(n) {
    if (n >= 0) {
        return this.slice(0, n);
    }

    throw Error('N should be a positive number');
}

Array.prototype.sum = function() {
    return this.reduce((prevVal, currentVal) => prevVal + currentVal, 0);
}

Array.prototype.average = function() {
    return this.sum() / this.length;
}

let arr = [1, 2, 3];
console.log(arr.skip(1));
console.log(arr);
console.log(arr.take(10))
console.log(arr.sum());
console.log(arr.average());


