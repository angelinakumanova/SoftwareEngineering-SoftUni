function validatePassword(password) {
    let isValid = true;

    if (password.length < 6 || password.length > 10) {
        console.log('Password must be between 6 and 10 characters');
        isValid = false;
    }
    
    if (/[\W]/.test(password) === true) {
        console.log('Password must consist only of letters and digits');
        isValid = false;
    }

    if (/\d{2}/.test(password) === false) {
        console.log('Password must have at least 2 digits');
        isValid = false;
    }

    if (isValid) {
        console.log('Password is valid');
    }
}

validatePassword('logIn');
validatePassword('MyPass123');
validatePassword('Pa$s$s');
