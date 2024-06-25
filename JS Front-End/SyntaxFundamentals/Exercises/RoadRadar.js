function checkSpeed(speed, area) {
    if (area == 'motorway') {
        if (speed <= 130) {
            console.log(`Driving ${speed} km/h in a 130 zone`);
        } else {
            console.log(`The speed is ${speed - 130} km/h faster than the allowed speed of 130 - ${checkSpeeding(speed, 130)}`);
        }
    } else if (area == 'interstate') {
        if (speed <= 90) {
            console.log(`Driving ${speed} km/h in a 90 zone`);
        } else {
            console.log(`The speed is ${speed - 90} km/h faster than the allowed speed of 90 - ${checkSpeeding(speed, 90)}`);
        }
    } else if (area == 'city') {
        if (speed <= 50) {
            console.log(`Driving ${speed} km/h in a 50 zone`);
        } else {
            console.log(`The speed is ${speed - 50} km/h faster than the allowed speed of 50 - ${checkSpeeding(speed, 50)}`);
        }
    } else if (area == 'residential') {
        if (speed <= 20) {
            console.log(`Driving ${speed} km/h in a 20 zone`);
        } else {
            console.log(`The speed is ${speed - 20} km/h faster than the allowed speed of 20 - ${checkSpeeding(speed, 20)}`);
        } 
    }

    function checkSpeeding (speed, limit) {
        let speeding = speed - limit;
    
        if (speeding <= 20) {
            return 'speeding';
        } else if (speeding <= 40) {
            return 'excessive speeding';
        } else {
            return 'reckless driving';
        }
    }
}



checkSpeed(40, 'city');
checkSpeed(21, 'residential');
checkSpeed(120, 'interstate');
checkSpeed(200, 'motorway');