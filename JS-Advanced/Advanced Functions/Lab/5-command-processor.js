function solution() {
    let string = '';
    
    const commands = {
        'append':  (text) => {
            string = string.concat(text);
        },
        'removeStart': (n) => {
            string = string.slice(n);
        },
        'removeEnd': (n) => {
            const stringLength = string.length;
            string = string.slice(0, stringLength - n);
        },
        'print': () => console.log(string)
        
    }

    return commands;
}

let firstZeroTest = solution();

firstZeroTest.append('hello');
firstZeroTest.append('again');
firstZeroTest.removeStart(3);
firstZeroTest.removeEnd(4);
firstZeroTest.print();

