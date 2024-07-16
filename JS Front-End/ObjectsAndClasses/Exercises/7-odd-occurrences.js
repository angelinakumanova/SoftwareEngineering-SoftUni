function solve(input) {
    const elementsTracker = {};
    const elements = input.split(/\s+/);

    for (let element of elements) {
        element = element.toLowerCase();

        if (elementsTracker[element]) {
            elementsTracker[element] += 1;
        } else {
            elementsTracker[element] = 1;
        }
        
    }

    const validElements = Object.entries(elementsTracker)
                                .filter(elementOccurrences => elementOccurrences[1] % 2 != 0)
                                .sort((firstElementOccurrences, secondElementOccurences) => secondElementOccurences[1] - firstElementOccurrences[1])
                                .map(([key, value]) => key)
                                .join(' ');

    console.log(validElements);
}

solve('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');
solve('Cake IS SWEET is Soft CAKE sweet Food');
