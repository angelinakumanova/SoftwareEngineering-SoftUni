window.addEventListener("load", solve);

function solve() {
  const checkList = document.getElementById('check-list');
  const contactsList = document.getElementById('contact-list');
  const nameInputElement = document.getElementById('name');
  const phoneInputElement = document.getElementById('phone');
  const categoryElement = document.getElementById('category');
  
  const addButton = document.getElementById('add-btn');
  
  addButton.addEventListener('click', (e) => {
    e.preventDefault;
    
    const name = nameInputElement.value;
    const phone = phoneInputElement.value;
    const category = categoryElement.value;
    
    if (name === '' ||
      phone === '' ||
      category === ''
    ) {
      return;
    }
    
    const listItem = createListItemElement(name, phone, category);
    const divElement = createDivOfButtons(edit, save);
    listItem.appendChild(divElement);
    
    checkList.appendChild(listItem);
    
    nameInputElement.value = '';
    phoneInputElement.value = '';
    categoryElement.value = '';
    
    
    function edit() {
      nameInputElement.value = name;
      phoneInputElement.value = phone;
      categoryElement.value = category;
      
      listItem.remove();
    }
    
    function save() {
      const divElement = listItem.querySelector('div.buttons');
      divElement.remove();
      
      const deleteButton = document.createElement('button');
      deleteButton.classList.add('del-btn');
      deleteButton.addEventListener('click', () => {
        contactsList.removeChild(listItem);
      });
      
      listItem.appendChild(deleteButton);
      
      checkList.removeChild(listItem);
      
      contactsList.appendChild(listItem);
    }
    
  });
  
  
  
  function createListItemElement(name, phone, category) {
    const listItemElement = document.createElement('li');
    const articleElement = document.createElement('article');
    
    const nameParagraphElement = document.createElement('p');
    nameParagraphElement.textContent = `name:${name}`;
    articleElement.appendChild(nameParagraphElement);
    
    const phoneParagraphElement = document.createElement('p');
    phoneParagraphElement.textContent = `phone:${phone}`;
    articleElement.appendChild(phoneParagraphElement);
    
    const categoryParagraphElement = document.createElement('p');
    categoryParagraphElement.textContent = `category:${category}`;
    articleElement.appendChild(categoryParagraphElement);
    
    listItemElement.appendChild(articleElement);
    
    
    
    return listItemElement;
  }
  
  function createDivOfButtons(edit, save) {
    const divElement = document.createElement('div');
    divElement.classList.add('buttons');
    
    const editButton = document.createElement('button');
    editButton.classList.add('edit-btn');
    editButton.addEventListener('click', edit);
    
    const doneButton = document.createElement('button');
    doneButton.classList.add('save-btn');
    doneButton.addEventListener('click', save);
    
    divElement.appendChild(editButton);
    divElement.appendChild(doneButton);
    
    return divElement;
  }
  
  
  
}
