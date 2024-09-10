function solve(text) {
    let pattern = /#[A-Za-z]+/g;
    let matches = text.match(pattern);

    for (let word of matches) {
        console.log(word.substring(1));
    }
}

solve('Nowadays everyone uses # to tag a #special word in #socialMedia');
solve('The symbol # is known #variously in English-speaking #regions as the #number sign');