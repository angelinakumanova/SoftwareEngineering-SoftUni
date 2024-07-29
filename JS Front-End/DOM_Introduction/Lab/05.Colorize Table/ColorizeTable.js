function colorize() {
    const evenTRElements = document.querySelectorAll('table tbody tr:nth-child(even)');

    for (const trElement of evenTRElements) {
        trElement.style.backgroundColor = 'teal';
    }
}
