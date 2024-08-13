window.addEventListener("load", solve);

function solve() {
    
  const previewList = document.getElementById('preview-list');
  const candidatesList = document.getElementById('candidates-list');

  const studentNameInput = document.getElementById('student');
  const universityInput = document.getElementById('university');
  const scoreInput = document.getElementById('score');

  const nextButton = document.getElementById('next-btn');

  nextButton.addEventListener('click', () => {

    const studentName = studentNameInput.value;
    const university = universityInput.value;
    const score = scoreInput.value;

    if (!studentName || !university || !score) {
      return;
    }

    const liElement = createLiElement(studentName, university, score, handleEdit, handleApply);
    
    previewList.appendChild(liElement);

    nextButton.disabled = true;

    studentNameInput.value = '';
    universityInput.value = '';
    scoreInput.value = '';


    function handleEdit() {
      studentNameInput.value = studentName;
      universityInput.value = university;
      scoreInput.value = score;

      previewList.removeChild(liElement);
      nextButton.disabled = false;
    }

    function handleApply() {
      const editButton = liElement.querySelector('button.edit');
      editButton.remove();

      const applyButton = liElement.querySelector('button.apply');
      applyButton.remove();

      previewList.removeChild(liElement);
      candidatesList.appendChild(liElement);

      nextButton.disabled = false;
    }
  });


  function createLiElement(studentName, university, score, handleEdit, handleApply) {
    const liElement = document.createElement('li');
    liElement.classList.add('application');

    const articleElement = document.createElement('article');
    articleElement.innerHTML = `
      <h4>${studentName}</h4>
      <p>University: ${university}</p>
      <p>Score: ${score}</p>
    `;

    liElement.appendChild(articleElement);

    const editButton = createButton('edit', handleEdit, 'action-btn', 'edit');
    const applyButton = createButton('apply', handleApply, 'action-btn', 'apply');

    liElement.appendChild(editButton);
    liElement.appendChild(applyButton);

    return liElement;
  }

  function createButton(text, func, ...classNames) {
    const button = document.createElement('button');
    button.textContent = text;
    button.classList.add(...classNames);
    button.addEventListener('click', func);

    return button;
  }
}
 