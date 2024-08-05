function lockedProfile() {
    const buttons = [...document.getElementsByTagName('button')];
    buttons.forEach(btn => btn.addEventListener('click', toggleShowHide));
    
    function toggleShowHide(event) {
        const button = event.target;
        const profile = button.closest('.profile');
        const additionalInformation = profile.getElementsByTagName('div')[0];
        const lockStatus = profile.querySelector('input[type="radio"]:checked').value;

        if (lockStatus === 'unlock') {
            if (button.textContent === 'Show more') {
                additionalInformation.style.display = 'block';
                button.textContent = 'Hide it';

            } else if (button.textContent === 'Hide it') {
                additionalInformation.style.display = 'none';
                button.textContent = 'Show more';
            }
        }
    }
}
