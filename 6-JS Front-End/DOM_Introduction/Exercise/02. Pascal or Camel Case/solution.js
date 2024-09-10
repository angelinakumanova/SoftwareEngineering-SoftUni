function solve() {
    const text = document.getElementById('text').value;
    const namingConvention = document.getElementById('naming-convention').value;

    let result = document.getElementById('result');

    const words = text.split(' ');
    if (namingConvention === 'Camel Case') {
      result.textContent += words[0].toLowerCase();
      
      for (let i = 1; i < words.length; i++) {
        result.textContent += words[i].charAt(0).toUpperCase() + words[i].slice(1).toLowerCase();
      }
    } else if (namingConvention === 'Pascal Case') {

      for (let word of words) {
        result.textContent += word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
      }
    } else {
      result.textContent = 'Error!';
    }
}
