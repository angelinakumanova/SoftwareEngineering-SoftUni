function solve() {
  const textAreaElement = document.getElementById('input');
  const input = textAreaElement.value;
  const outputElement = document.getElementById('output');

  const result = input.split('.')
      .filter(sentence => !!sentence)
      .reduce((result, sentence, i) => {
        const resultIndex = Math.floor(i / 3);
        
        if (!result[resultIndex]) {
          result[resultIndex] = [];
        }

        result[resultIndex].push(sentence.trim());

        return result;
      }, [])
      .map(sentences => `<p>${sentences.join('. ')}.</p>`)
      .join('');

      console.log(result);

  outputElement.innerHTML = result;
  
}
