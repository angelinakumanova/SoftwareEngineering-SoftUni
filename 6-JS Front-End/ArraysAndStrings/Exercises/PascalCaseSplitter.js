function solve(text) {
    const regex = /(?=[A-Z])/;

    let words = text.split(regex);
    console.log(words.join(', '));
}

solve('SplitMeIfYouCanHaHaYouCantOrYouCan');
solve('HoldTheDoor');
solve('ThisIsSoAnnoyingToDo');