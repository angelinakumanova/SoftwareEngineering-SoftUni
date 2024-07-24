function extractText() {
    const items = document.getElementById('items').innerText;
    
    const textArea = document.getElementById('result');
    textArea.textContent = items;
}
