function solve() {
   //get element references
   const productCatalogElement = document.querySelector('.shopping-cart');
   const checkoutButton = document.querySelector('.checkout');
   const textAreaElement = document.querySelector('textarea[disabled]');

   const products = [];
   
   //add event handler to 'Add' button
   productCatalogElement.addEventListener('click', (e) => {

      if (e.target.tagName !== 'BUTTON') {
         return;
      }

      if (e.target.textContent.trim() !== 'Add') {
         return;
      }

      const productElement = e.target.closest('.product');
      const name = productElement.querySelector('.product-title').textContent;
      const price = Number(productElement.querySelector('.product-line-price').textContent);
      
      products.push({
         name,
         price,
      });

      textAreaElement.value += `Added ${name} for ${price.toFixed(2)} to the cart.\n`;
   });

   //add event handler to 'Checkout' button
   checkoutButton.addEventListener('click', (e) => {
      // calculate total money
      const totalPrice = products.reduce((price, currentProduct) => (price + currentProduct.price), 0);
      
      // collect unique products
      const uniqueProducts = [...new Set(products.map(product => product.name))];


      // append checkout text to textarea
      textAreaElement.value += `You bought ${uniqueProducts.join(', ')} for ${totalPrice.toFixed(2)}.`;

      // disable all buttons
      document.querySelectorAll('button').forEach(el => el.setAttribute('disabled', 'disabled'));
   });
   

   
}
