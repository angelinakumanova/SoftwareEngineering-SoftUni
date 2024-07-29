function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      const trElements = document.querySelectorAll('tbody tr');
      const searchFieldElement = document.getElementById('searchField');
      const searchedValue = searchFieldElement.value;

      for (const trElement of trElements) {
         trElement.classList.remove('select');

         if (trElement.textContent.includes(searchedValue)) {
            trElement.classList.add('select');
         }
      }

      searchFieldElement.value = '';
   } 
}
