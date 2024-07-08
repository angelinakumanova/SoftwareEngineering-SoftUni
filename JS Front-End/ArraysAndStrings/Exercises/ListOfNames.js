function solve(array) {
    array.sort((a,b) => a.localeCompare(b)).forEach((element, idx) => {
        const pos = idx + 1;
        console.log(`${pos}.${element}`);
    });
}

solve(["John", "Bob", "Christina", "Ema"]);