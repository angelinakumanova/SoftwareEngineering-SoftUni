function sumTable() {
    const resultElement = document.getElementById('sum');
    const tdElements = document.querySelectorAll('table tr td:nth-child(2):not(#sum)');

    resultElement.textContent = Array.from(tdElements)
                                    .reduce((sum, td) => sum + Number(td.textContent), 0);;
}
