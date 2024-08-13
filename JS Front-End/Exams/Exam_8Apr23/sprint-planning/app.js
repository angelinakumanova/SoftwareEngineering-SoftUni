window.addEventListener('load', solve);

function solve() {
    const tasks = [];
    
    const tasksSection = document.getElementById('tasks-section');
    const totalPointsElement = document.getElementById('total-sprint-points');
    const taskIDElement = document.getElementById('task-id');
    let taskID = taskIDElement.value = 1;
    
    const titleInput = document.getElementById('title');
    const descriptionTextArea = document.getElementById('description');
    const labelSelect = document.getElementById('label');
    const pointsInput = document.getElementById('points');
    const assigneeInput = document.getElementById('assignee');
    
    const createButton = document.getElementById('create-task-btn');
    const deleteButton = document.getElementById('delete-task-btn');
    
    createButton.addEventListener('click', () => {
        const title = titleInput.value;
        const description = descriptionTextArea.value;
        const label = labelSelect.value;
        const points = pointsInput.value;
        const assignee = assigneeInput.value;
        
        if (!title || !description || !label || !points || !assignee) {
            return;
        }
        
        
        const article = createArticleElement(title, description, label, points, assignee, taskID, deleteCurrent);
        tasksSection.appendChild(article);
        
        const currentPoints = Number(((totalPointsElement.textContent.split(' ')[2]).split('pts'))[0]);
        const updatedPoints = currentPoints + Number(points);
        totalPointsElement.textContent = `Total Points ${updatedPoints}pts`;
        
        taskID += 1;
        
        titleInput.value = '';
        descriptionTextArea.value = '';
        labelSelect.value = '';
        pointsInput.value = '';
        assigneeInput.value = '';
        
        function deleteCurrent() {
            titleInput.value = title;
            descriptionTextArea.value = description;
            labelSelect.value = label;
            pointsInput.value = points;
            assigneeInput.value = assignee;
            
            titleInput.disabled = true;
            descriptionTextArea.disabled = true;
            labelSelect.disabled = true;
            pointsInput.disabled = true;
            assigneeInput.disabled = true;
            
            deleteButton.disabled = false;
            createButton.disabled = true;
            
            deleteButton.addEventListener('click', () => {
                const id = Number((article.id.split('-'))[1]);
                const currentTask = tasks.find(task => task.taskID === id);
                
                const currentPoints = Number(((totalPointsElement.textContent.split(' ')[2]).split('pts'))[0]);
                const currentTaskPoints = currentTask.points;
                const updatedPoints = currentPoints - currentTaskPoints;
                totalPointsElement.textContent = `Total Points ${updatedPoints}pts`;
                
                article.remove();
                removeTask(id - 1);
                
                titleInput.value = '';
                descriptionTextArea.value = '';
                labelSelect.value = '';
                pointsInput.value = '';
                assigneeInput.value = '';
                
                titleInput.disabled = false;
                descriptionTextArea.disabled = false;
                labelSelect.disabled = false;
                pointsInput.disabled = false;
                assigneeInput.disabled = false;
                
                deleteButton.disabled = true;
                createButton.disabled = false;
            });
        }
    });
    
    
    
    function createArticleElement(title, description, label, points, assignee, taskID, deleteCurrent) {
        addTaskToTasks(taskID, title, description, label, points, assignee);
        
        const articleElement = document.createElement('article');
        articleElement.id = `task-${taskID}`;
        articleElement.classList.add('task-card');
        
        const divLabel = createDivLabel(label);
        articleElement.appendChild(divLabel);
        
        const titleElement = document.createElement('h3');
        titleElement.classList.add('task-card-title');
        titleElement.textContent = title;
        articleElement.appendChild(titleElement);
        
        const descriptionElement = document.createElement('p');
        descriptionElement.classList.add('task-card-description');
        descriptionElement.textContent = description;
        articleElement.appendChild(descriptionElement);
        
        const pointsElement = document.createElement('div');
        pointsElement.classList.add('task-card-points');
        pointsElement.textContent = `Estimated at ${points} pts`;
        articleElement.appendChild(pointsElement);
        
        const assigneeElement = document.createElement('div');
        assigneeElement.classList.add('task-card-assignee');
        assigneeElement.textContent = `Assigned to: ${assignee}`;
        articleElement.appendChild(assigneeElement);
        
        const actionDivElement = document.createElement('div');
        actionDivElement.classList.add('task-card-actions');
        
        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', deleteCurrent);
        actionDivElement.appendChild(deleteButton);
        
        articleElement.appendChild(actionDivElement);
        
        return articleElement;
    }
    
    function createDivLabel(label) {
        const div = document.createElement('div');
        div.classList.add('task-card-label');
        
        if (label === 'Feature') {
            div.classList.add('feature');
            div.innerHTML = 'Feature &#8865;';
            
        } else if (label === 'Low Priority Bug') {
            div.classList.add('low-priority');
            div.innerHTML = 'Low Priority Bug &#9737;';
            
        } else if (label === 'High Priority Bug') {
            div.classList.add('high-priority');
            div.innerHTML = 'High Priority Bug &#9888;';
            
        }
        
        return div;
    }
    
    
    function addTaskToTasks(taskID, title, description, label, points, assignee) {
        const task = {
            taskID,
            title,
            description,
            label,
            points: Number(points),
            assignee,
        };
        
        tasks.push(task);
    }
    
    function removeTask(index) {
        tasks.splice(index, 1);
    }
}      
