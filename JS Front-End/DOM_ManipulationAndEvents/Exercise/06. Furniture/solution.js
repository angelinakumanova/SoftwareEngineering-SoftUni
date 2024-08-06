function solve() {
  const generateButton = document.querySelector('#exercise > button');
  const tableBodyElement = document.querySelector('.table tbody');
  const buyButton = document.querySelector('#exercise button:nth-of-type(2)');
  const displayTextArea = document.querySelector('#exercise textarea[disabled]');
  
  generateButton.addEventListener('click', () => {
    const parsedInputValue = JSON.parse(document.querySelector('#exercise > textarea').value);
    
    for (const furniture of parsedInputValue) {
      const furnitureTrElement = convertObjectIntoTrElement(furniture);
      
      tableBodyElement.append(furnitureTrElement);
    }
    
  });
  
  
  
  
  buyButton.addEventListener('click', (e) => {
    const checkedBoxes = document.querySelectorAll('.table tbody input[type=checkbox]:checked');
    const boughtFurniture = Array.from(checkedBoxes).map(el => el.closest('tr'));
    
    const furnitureNames = boughtFurniture.map(el => {
      const nameElement = el.querySelector('td:nth-of-type(2) p');
      
      return nameElement.textContent;
    });
    
    const totalPriceOfFurniture = boughtFurniture.map(el => {
      const priceElement = el.querySelector('td:nth-of-type(3) p');
      
      return Number(priceElement.textContent);
    })
    .reduce((sum, price) => sum + price, 0);
    
    const averageDecorationFactor = boughtFurniture.map(el => {
      const decFactorElement = el.querySelector('td:nth-of-type(4) p');
      
      return Number(decFactorElement.textContent);
    })
    .reduce((sum, decFactor, _, array) => sum + decFactor / array.length, 0);
    
    
    const message = `Bought furniture: ${furnitureNames.join(', ')}\nTotal price: ${totalPriceOfFurniture.toFixed(2)}\nAverage decoration factor: ${averageDecorationFactor}`;
    
    displayTextArea.value = message;
  });
  
  
  
  
  
  function convertObjectIntoTrElement(furniture) {
    const trElement = document.createElement('tr');
    
    for (const info in furniture) {
      const content = (info === 'img') ? createImgElement(furniture[info]) : createTextElement(furniture[info]);
      const tdElement = createTdElement(content);
      
      trElement.append(tdElement);
    }
    
    const inputElement = createInputElement();
    const inputTdElement = createTdElement(inputElement);
    trElement.append(inputTdElement);
    
    return trElement;
  }
  
  function createTdElement(content) {
    const tdElement = document.createElement('td');
    tdElement.append(content);
    
    return tdElement;
  }
  
  function createImgElement(src) {
    const imgElement = document.createElement('img');
    imgElement.src = src;
    
    return imgElement;
  }
  
  function createTextElement(text) {
    const textElement = document.createElement('p');
    textElement.textContent = text;
    
    return textElement;
  }
  
  function createInputElement() {
    const inputElement = document.createElement('input');
    inputElement.type = 'checkbox';
    
    return inputElement;
  }
  
}
