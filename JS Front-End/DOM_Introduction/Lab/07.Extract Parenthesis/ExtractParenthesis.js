function extract(content) {
    const textElement = document.getElementById(content);

    const pattern = /\(([^()]+)\)/g;

    const matches = textElement.textContent.matchAll(pattern);

    const result = Array.from(matches).map(match => match[1]).join(';');
    
    return result;
}
