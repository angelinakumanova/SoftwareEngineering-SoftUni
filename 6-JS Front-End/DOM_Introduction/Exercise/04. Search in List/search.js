function search() {
   const townsLiElements = document.querySelectorAll('ul li');
   const searchedTowns = document.getElementById('searchText').value;
   
   let matchCounter = 0;
   for (const townLiElement of townsLiElements) {
      if (townLiElement.textContent.toLowerCase().includes(searchedTowns.toLowerCase())) {
         townLiElement.style.textDecoration = 'underline';
         townLiElement.style.fontWeight = 'bold';
         matchCounter++;
      } else {
         townLiElement.style.textDecoration = 'none';
         townLiElement.style.fontWeight = 'normal';
      }
   }

   const resultElement = document.getElementById('result');
   resultElement.textContent = `${matchCounter} matches found`;
   
}
