window.addEventListener("load", solve);

function solve() {
  const firstNameInput = document.getElementById('first-name');
  const lastNameInput = document.getElementById('last-name');
  const ageInput = document.getElementById('age');
  const storyTitleInput = document.getElementById('story-title');
  const genreElement = document.getElementById('genre');
  const storyTextArea = document.getElementById('story');
  
  const previewList = document.getElementById('preview-list');
  
  const publishButton = document.getElementById('form-btn');
  
  publishButton.addEventListener('click', () => {
    const firstName = firstNameInput.value;
    const lastName = lastNameInput.value;
    const age = ageInput.value;
    const storyTitle = storyTitleInput.value;
    const genre = genreElement.value;
    const storyText = storyTextArea.value;
    
    if (!firstName || !lastName || !age || !storyTitle || !genre || !storyText) {
      return;
    }
    
    const storyElement = createStoryLiElement(firstName, lastName, age, storyTitle, genre, storyText);
    previewList.appendChild(storyElement);
    
    firstNameInput.value = '';
    lastNameInput.value = '';
    ageInput.value = '';
    storyTitleInput.value = '';
    genreElement.value = '';
    storyTextArea.value = '';
    
    publishButton.disabled = true;
  })
  
  function createStoryLiElement(firstName, lastName, age, storyTitle, genre, storyText) {
    const liElement = document.createElement('li');
    liElement.classList.add('story-info');
    
    const articleElement = document.createElement('article');
    articleElement.innerHTML = `
      <h4>Name: ${firstName} ${lastName}</h4>
      <p>Age: ${age}</p>
      <p>Title: ${storyTitle}</p>
      <p>Genre: ${genre}</p>
      <p>${storyText}</p>
    `;
    liElement.appendChild(articleElement);
    
    const saveButton = document.createElement('button');
    saveButton.classList.add('save-btn');
    saveButton.textContent = 'Save Story';
    saveButton.addEventListener('click', () => {
      const mainDiv = document.getElementById('main');
      mainDiv.innerHTML = '';
      mainDiv.innerHTML = `
        <h1>Your scary story is saved!</h1>
      `;
    });
    liElement.appendChild(saveButton);
    
    const editButton = document.createElement('button');
    editButton.classList.add('edit-btn');
    editButton.textContent = 'Edit Story';
    editButton.addEventListener('click', () => {
      firstNameInput.value = firstName;
      lastNameInput.value = lastName;
      ageInput.value = age;
      storyTitleInput.value = storyTitle;
      genreElement.value = genre;
      storyTextArea.value = storyText;

      publishButton.disabled = false;
      liElement.remove();
    });
    liElement.appendChild(editButton);
    
    const deleteButton = document.createElement('button');
    deleteButton.classList.add('delete-btn');
    deleteButton.textContent = 'Delete Story';
    deleteButton.addEventListener('click', () => {
      liElement.remove();

      publishButton.disabled = false;
    })
    liElement.appendChild(deleteButton);
    
    return liElement;
  }
  
  
}
