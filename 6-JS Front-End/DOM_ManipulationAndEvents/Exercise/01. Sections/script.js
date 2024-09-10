function create(words) {
   const contentElement = document.getElementById('content');
   
   for (const word of words) {
      const divElement = document.createElement('div');
      const pElement = document.createElement('p');

      pElement.textContent = word;
      pElement.setAttribute('style', 'display: none;');

      divElement.append(pElement);
      contentElement.append(divElement);
   }
   
   
   document.querySelectorAll('div#content > div').forEach(el => el.addEventListener('click', (e) => {
      console.log(e.currentTarget.querySelector('p'));
      e.currentTarget.querySelector('p').setAttribute('style', 'display:block');
   }));
}
