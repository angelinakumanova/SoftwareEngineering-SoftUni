function solve(loginInput) {
    let username = loginInput[0];
    let correctPassword = username.split('').reverse().join('');

    let countIncorrectInputs = 0;
    for(let i = 1; i < loginInput.length; i++) {
        if (loginInput[i] === correctPassword) {
            console.log(`User ${username} logged in.`)
            break;
        } else  {
            countIncorrectInputs++;
            if (countIncorrectInputs === 4) {
                console.log(`User ${username} blocked!`)
                break;
            }
            console.log('Incorrect password. Try again.');
            
        }
    }
}

solve(['Acer','login','go','let me in','recA']);
solve(['momo','omom']);
solve(['sunny','rainy','cloudy','sunny','not sunny']);