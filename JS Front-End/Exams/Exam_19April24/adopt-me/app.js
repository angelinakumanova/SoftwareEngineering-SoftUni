window.addEventListener("load", solve);

function solve() {
  const listWithAnimals = document.getElementById('adoption-info');
  const adoptedAnimalsList = document.getElementById('adopted-list');
  const animalTypeInputElement = document.getElementById('type');
  const animalAgeInputElement = document.getElementById('age');
  const animalGenderSelectElement = document.getElementById('gender');
  
  const adoptButton = document.getElementById('adopt-btn');
  
  
  adoptButton.addEventListener('click', (e) => {
    e.preventDefault();
    const animalType = animalTypeInputElement.value;
    const animalAge = animalAgeInputElement.value;
    const animalGender = animalGenderSelectElement.value;
    
    const listItemElement = createListItemElement(animalType, animalAge, animalGender);
    const divElement = createDivOfButtons(edit, addToAdopted);
    listItemElement.appendChild(divElement);
    
    listWithAnimals.appendChild(listItemElement);
    
    animalTypeInputElement.value = '';
    animalAgeInputElement.value = '';
    animalGenderSelectElement.value = '';
    
    
    function edit() {
      animalTypeInputElement.value = animalType;
      animalAgeInputElement.value = animalAge;
      animalGenderSelectElement.value = animalGender;
      
      listItemElement.remove();
    }

    function addToAdopted() {
        const divElement = listItemElement.querySelector('div.buttons');
        divElement.remove();
        
        const clearButton = document.createElement('button');
        clearButton.classList.add('clear-btn');
        clearButton.textContent = 'Clear';
        clearButton.addEventListener('click', clearCurrentAnimal);
        listItemElement.appendChild(clearButton);
        
        listWithAnimals.removeChild(listItemElement);
        
        adoptedAnimalsList.appendChild(listItemElement);
    }

    function clearCurrentAnimal() {
        
        listItemElement.remove();
      }
      
  });

  
  
  
  
  
  function createListItemElement(animalType, animalAge, animalGender) {
    const listItemElement = document.createElement('li');
    const articleElement = document.createElement('article');
    
    const typeParagraphElement = document.createElement('p');
    typeParagraphElement.textContent = `Pet:${animalType}`;
    articleElement.appendChild(typeParagraphElement);
    
    const genderParagraphElement = document.createElement('p');
    genderParagraphElement.textContent = `Gender:${animalGender}`;
    articleElement.appendChild(genderParagraphElement);
    
    const ageParagraphElement = document.createElement('p');
    ageParagraphElement.textContent = `Age:${animalAge}`;
    articleElement.appendChild(ageParagraphElement);
    
    listItemElement.appendChild(articleElement);
    
    return listItemElement;
  }
  
  function createDivOfButtons(edit, done) {
    const divElement = document.createElement('div');
    divElement.classList.add('buttons');
    
    const editButton = document.createElement('button');
    editButton.classList.add('edit-btn');
    editButton.textContent = 'Edit';
    editButton.addEventListener('click', edit);
    
    const doneButton = document.createElement('button');
    doneButton.classList.add('done-btn');
    doneButton.textContent = 'Done';
    doneButton.addEventListener('click', done);
    
    divElement.appendChild(editButton);
    divElement.appendChild(doneButton);
    
    return divElement;
  }
  
}
