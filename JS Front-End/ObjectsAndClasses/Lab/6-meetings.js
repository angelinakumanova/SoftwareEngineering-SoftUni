function solve(input) {
    const schedule = {};

    for (const line of input) {
        const tokens = line.split(' ');
        const day = tokens[0];
        const personName = tokens[1];

        if (schedule.hasOwnProperty(day)) {
            console.log(`Conflict on ${day}!`);
        } else {
            schedule[day] = personName;
            console.log(`Scheduled for ${day}`);
        }
    }

    for (const day in schedule) {
        console.log(`${day} -> ${schedule[day]}`)
    }
}

solve(['Monday Peter','Wednesday Bill','Monday Tim','Friday Tim']);

