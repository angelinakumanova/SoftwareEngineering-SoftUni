function attachGradientEvents() {
    const gradientElement = document.getElementById('gradient');
    const resultElement = document.getElementById('result');

    gradientElement.addEventListener('mousemove', (e) => {
        const currentPosition = e.offsetX;
        const elementWidth = gradientElement.clientWidth;

        const currentPercentage = Math.floor((currentPosition / elementWidth) * 100);

        resultElement.textContent = `${currentPercentage}%`;
        
    });

}
