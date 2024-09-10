function toggle() {
    const buttonElement = document.querySelector('.head span.button');
    const divElement = document.querySelector('#extra');

    const isHidden = divElement.style.display === 'none';

    if (isHidden || !divElement.style.display) {
        buttonElement.textContent = 'Less';
        divElement.style.display = 'block';
    } else {
        buttonElement.textContent = 'More';
        divElement.style.display = 'none';
    }
    
}
