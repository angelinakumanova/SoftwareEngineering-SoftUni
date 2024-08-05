function attachEventsListeners() {
    const dayConvertButton = document.getElementById('daysBtn');
    const hoursConvertButton = document.getElementById('hoursBtn');
    const minutesConvertButton = document.getElementById('minutesBtn');
    const secondsConvertButton = document.getElementById('secondsBtn');

    const daysInputElement = document.getElementById('days');
    const hoursInputElement = document.getElementById('hours');
    const minutesInputElement = document.getElementById('minutes');
    const secondsInputElement = document.getElementById('seconds');

    dayConvertButton.addEventListener('click', () => {
        hoursInputElement.value = Number(daysInputElement.value) * 24;
        minutesInputElement.value = Number(daysInputElement.value) * 1440;
        secondsInputElement.value = Number(daysInputElement.value) * 86400 ;
    });

    hoursConvertButton.addEventListener('click', () => {
        daysInputElement.value = Number(hoursInputElement.value) / 24;
        minutesInputElement.value = Number(daysInputElement.value) * 1440;
        secondsInputElement.value = Number(daysInputElement.value) * 86400 ;
    });

    minutesConvertButton.addEventListener('click', () => {
        daysInputElement.value = Number(minutesInputElement.value) / 1440;
        hoursInputElement.value = Number(daysInputElement.value) * 24;
        secondsInputElement.value = Number(daysInputElement.value) * 86400 ;
    });

    secondsConvertButton.addEventListener('click', () => {
        daysInputElement.value = Number(secondsInputElement.value) / 86400;
        hoursInputElement.value = Number(daysInputElement.value) * 24;
        minutesInputElement.value = Number(daysInputElement.value) * 1440 ;
    });

}
