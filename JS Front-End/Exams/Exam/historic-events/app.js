window.addEventListener("load", solve);

function solve() {
  const eventNameInput = document.getElementById('name');
  const timeInput = document.getElementById('time');
  const descriptionElement = document.getElementById('description');
  
  const addButton = document.getElementById('add-btn');
  
  const previewList = document.getElementById('preview-list');
  const archiveList = document.getElementById('archive-list');
  
  addButton.addEventListener('click', () => {
    const eventName = eventNameInput.value;
    const time = timeInput.value;
    const description = descriptionElement.value;
    
    if (!eventName || !time || !description) {
      return;
    }
    
    const liElement = createLiElement(eventName, time, description);
    previewList.appendChild(liElement);
    
    
    eventNameInput.value = '';
    timeInput.value = '';
    descriptionElement.value = '';

    addButton.disabled = true;
  })
  
  
  function createLiElement(eventName, time, description) {
    const liElement = document.createElement('li');
    
    const articleElement = document.createElement('article');
    articleElement.innerHTML = `
      <p>${eventName}</p>
      <p>${time}</p>
      <p>${description}</p>
    `;
    liElement.appendChild(articleElement);
    
    const buttonsDiv = document.createElement('div');
    buttonsDiv.classList.add('buttons');
    
    const editButton = document.createElement('button');
    editButton.classList.add('edit-btn');
    editButton.textContent = 'Edit';
    editButton.addEventListener('click', () => edit(eventName, time, description, liElement));
    buttonsDiv.appendChild(editButton);
    
    const nextButton = document.createElement('button');
    nextButton.classList.add('next-btn');
    nextButton.textContent = 'Next';
    nextButton.addEventListener('click', () => {
      buttonsDiv.remove();
      next(liElement);
    });
    buttonsDiv.appendChild(nextButton);
    
    liElement.appendChild(buttonsDiv);
    
    return liElement;
  }
  
  function edit(eventName, time, description, liElement) {
    eventNameInput.value = eventName;
    timeInput.value = time;
    descriptionElement.value = description;
    
    liElement.remove();
    
    addButton.disabled = false;
  }
  
  function next(liElement) {
    liElement.remove();
    archiveList.appendChild(liElement);
    
    const archiveButton = document.createElement('button');
    archiveButton.classList.add('archive-btn');
    archiveButton.textContent = 'Archive';
    archiveButton.addEventListener('click', () => {
      liElement.remove();
      addButton.disabled = false;
    });
    liElement.appendChild(archiveButton);
  }
  
  
}
