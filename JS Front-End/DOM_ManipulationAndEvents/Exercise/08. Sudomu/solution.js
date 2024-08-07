function solve() {
    const tableElement = document.querySelector('table');
    const trElements = document.querySelectorAll('table tbody tr');
    const resultOutput = document.querySelector('#check p');
    const allInputElements = document.querySelectorAll('table tbody input');

    const allButtons = document.querySelectorAll('#exercise tfoot button');
    const quickCheckButton = allButtons[0];
    const clearButton = allButtons[1];
    
    quickCheckButton.addEventListener('click', () => {
        let isValid = isValidSudoku(trElements);
       
        if (isValid) {
            tableElement.setAttribute('style', 'border: 2px solid green');
            resultOutput.textContent = 'You solve it! Congratulations!';
            resultOutput.setAttribute('style', 'color: green');
        } else {
            tableElement.setAttribute('style', 'border: 2px solid red');
            resultOutput.textContent = 'NOP! You are not done yet...';
            resultOutput.setAttribute('style', 'color: red');
        }
        
    });

    clearButton.addEventListener('click', () => {
        tableElement.setAttribute('style', 'border: none');
        resultOutput.textContent = '';

        allInputElements.forEach((el) => el.value = '');
    });
    

    function isValidSudoku(trElements) {
        const isValidByColumns = validateByColumn(trElements);
        const isValidByRows = validateByRow(trElements);

        return isValidByColumns && isValidByRows;
        
    }

    function validateByColumn(trElements) {
        let columnElementPos = 0;

        for (const column of trElements) {
            
            const currentColumnNumbers = new Set();
            
            for (const row of trElements) {
                const currentNumber = Number(row.querySelectorAll('td input')[columnElementPos].value);
                currentColumnNumbers.add(currentNumber);
            }
            columnElementPos++;

            if (checkForDuplicates(currentColumnNumbers)) {
                return false;
            }
        }
        return true;
    }

    function validateByRow(trElements) {

        for (const row of trElements) {
            const currentNumbers = new Set(Array.from(row.querySelectorAll('td input')).map(el => Number(el.value)));


            if (checkForDuplicates(currentNumbers)) {
                return false;
            }
        }

        return true;
    }

    function checkForDuplicates(set) {
        return set.size !== trElements.length;
    }
}
