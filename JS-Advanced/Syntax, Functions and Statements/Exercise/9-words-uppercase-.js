function solve(input) {
    const regex = /\w+/g;

    const result = [...input.matchAll(regex)].map(arr => arr[0].toUpperCase()).join(', ');
    console.log(result);
    
}

solve('Hi, how are you?');
