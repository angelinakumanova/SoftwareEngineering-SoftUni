function solve(number, ...commands) {
    number = Number(number);
    
    const operations = {
        'chop': a => a / 2,
        'dice': a => Math.sqrt(a),
        'spice': a => a + 1,
        'bake': a => a * 3,
        'fillet': a => a * 0.8,
    };

    commands.forEach(command => {
        number = operations[command](number);
        console.log(number);
    });
}

solve('32', 'chop', 'chop', 'chop', 'chop', 'chop');
