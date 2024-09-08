function solve(area, vol, input) {
    const data = JSON.parse(input);
    const calculatedData = [];

    for (const points of data) {
        const result = Object.keys(points)
                    .reduce((result, key) => ({...result, [key]: Number(points[key])}), {});

        calculatedData.push({
                area: area.call(result),
                volume: vol.call(result),
            });
    }

    return calculatedData;
}

function area() {
    return Math.abs(this.x * this.y);
};

function vol() {
    return Math.abs(this.x * this.y * this.z);
};

console.log(solve(area, vol, `[
    {"x":"1","y":"2","z":"10"},
    {"x":"7","y":"7","z":"10"},
    {"x":"5","y":"2","z":"10"}
    ]`));
