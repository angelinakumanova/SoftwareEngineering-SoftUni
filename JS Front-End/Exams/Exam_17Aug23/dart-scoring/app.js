window.addEventListener("load", solve);

function solve() {
  const sureList = document.getElementById('sure-list')   ;
  const scoreboardList = document.getElementById('scoreboard-list');
  
  const playerInput = document.getElementById('player');
  const scoreInput = document.getElementById('score');
  const roundInput = document.getElementById('round');
  
  const addButton = document.getElementById('add-btn');
  const clearButton = document.querySelector('.btn.clear');
  
  addButton.addEventListener('click', (e) => {
    e.preventDefault();
    
    const player = playerInput.value;
    const score = scoreInput.value;
    const round = roundInput.value;
    
    if (!player || !score || !round) {
      return;
    }
    
    const listItem = createLiElement(player, score, round);
    const editButton = document.createElement('button');
    editButton.classList.add('btn', 'edit');
    editButton.textContent = 'edit';
    editButton.addEventListener('click', handleEdit);
    
    listItem.appendChild(editButton);
    
    const okButton = document.createElement('button');
    okButton.classList.add('btn', 'ok');
    okButton.textContent = 'ok';
    okButton.addEventListener('click', handleOk);
    
    listItem.appendChild(okButton);
    
    
    addButton.disabled = true;
    
    sureList.appendChild(listItem);
    
    playerInput.value = '';
    scoreInput.value = '';
    roundInput.value = '';
    
    function handleEdit() {
      playerInput.value = player;
      scoreInput.value = score;
      roundInput.value = round;
      
      sureList.removeChild(listItem);
      addButton.disabled = false;
    }
    
    function handleOk() {
      editButton.remove();
      okButton.remove();
      
      sureList.removeChild(listItem);
      scoreboardList.appendChild(listItem);
      
      
      addButton.disabled = false;
    }
  });
  
  clearButton.addEventListener('click', () => {
    location.reload();
  });
  
  
  function createLiElement(player, score, round) {
    const liElement = document.createElement('li');
    liElement.classList.add('dart-item');
    
    const articleElement = document.createElement('article');
    
    articleElement.innerHTML = `
        <p>${player}</p>
        <p>Score: ${score}</p>
        <p>Round: ${round}</p>
    `;
    
    
    liElement.appendChild(articleElement);
    
    
    
    return liElement;
  }
  
}
