function attachEventsListeners() {
    const inputUnits = document.getElementById('inputUnits');
    const outputUnits = document.getElementById('outputUnits');
    const convertButton = document.getElementById('convert');
    const inputResult = document.getElementById('inputDistance');
    const outputResult = document.getElementById('outputDistance');

    convertButton.addEventListener('click', () => {
        const currentInputValue = inputUnits.value;
        const currentOutputValue = outputUnits.value;
        const currentValue = inputResult.value;

        const result = convert(currentInputValue, currentValue, currentOutputValue);

        outputResult.value = result;
    });
    
    function convert(inputUnit, unitValue, outputUnit) {
        const converter = {
            'km': 1000,
            'm': 1,
            'cm': 0.01,
            'mm': 0.001,
            'mi': 1609.34,
            'yrd': 0.9144,
            'ft': 0.3048,
            'in': 0.0254
        };

        const convertedInputToMeters = unitValue * converter[inputUnit];

        const convertedResultToUnit = convertedInputToMeters / converter[outputUnit];
        
        return convertedResultToUnit;
    };
}
