function generateReport() {
    const thElements = document.querySelectorAll('table thead th');
    const textAreaElement = document.getElementById('output');

    const data = [];

    let currentElementCounter = 0;
    for (const thElement of thElements) {
        currentElementCounter++;
        const thElementInputChild = thElement.children[0];
        const checkedCheckbox = thElementInputChild.checked;

        if (checkedCheckbox) {
            const propertyName = thElementInputChild.name;
            const infoAtCurrentColumn = Array.from(document.querySelectorAll(`table tbody tr td:nth-child(${currentElementCounter})`)).map(e => e.textContent);
            
            for (let i = 0; i < infoAtCurrentColumn.length; i++) {
                
                if(data[i] === undefined) {
                    data[i] = {};
                }
                
                data[i][propertyName] = infoAtCurrentColumn[i];
                

            }
            
        }
    }

    textAreaElement.value = JSON.stringify(data);
}
