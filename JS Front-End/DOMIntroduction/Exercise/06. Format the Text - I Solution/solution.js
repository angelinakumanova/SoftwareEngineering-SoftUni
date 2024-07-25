function solve() {
  const textAreaElement = document.getElementById('input');
  const input = textAreaElement.value.split('.');
  input.pop();

  const outputElement = document.getElementById('output');

  let sentencesCounter = 0;
  let currentParagraph = '';
  for (const sentence of input) {
    if (sentencesCounter === 3) {
      outputElement.innerHTML += `<p>${currentParagraph}</p>`;
      currentParagraph = '';
      sentencesCounter = 0;
    }

    currentParagraph += sentence + '.';
    sentencesCounter++;
  }

  if (currentParagraph != '') {
    outputElement.innerHTML += `<p>${currentParagraph}</p>`;
  }
  
  
}
