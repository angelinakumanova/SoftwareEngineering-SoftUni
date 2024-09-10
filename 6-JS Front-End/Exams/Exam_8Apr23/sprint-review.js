function solve([numberOfAssignees, ...rest]) { 
    const assignees = [];
    
    (rest.slice(0,numberOfAssignees)).map(assignee => {
        const tokens = assignee.split(':');
        const name = tokens[0];

        const taskID = tokens[1];
        const title = tokens[2];
        const status = tokens[3];
        const estimatedPoints = Number(tokens[4]);

        const task = {
            taskID,
            title,
            status,
            estimatedPoints,
        };

        const existingAssignee = assignees.find(a => a.name === name);

        if (!existingAssignee) {
            assignees.push({
                name,
                tasks: [task],
            });
            return;
        }
        
        existingAssignee.tasks.push(task);
        return existingAssignee;
    });
    
    const commands = rest.slice(numberOfAssignees);
    
    for (const command of commands) {
        const tokens = command.split(':');
        const action = tokens[0];
        const assigneeName = tokens[1];
        
        const assignee = assignees.find(a => a.name === assigneeName);
        
        if (!assignee) {
            console.log(`Assignee ${assigneeName} does not exist on the board!`);
            continue;
        } 
        
        if (action === 'Add New') {
            const taskID = tokens[2];
            const title = tokens[3];
            const status = tokens[4];
            const estimatedPoints = Number(tokens[5]);

            const task = {
                taskID,
                title,
                status,
                estimatedPoints,
            };

            assignee.tasks.push(task);
        } else if (action === 'Change Status') {
            const taskID = tokens[2];
            const newStatus = tokens[3];

            const task = assignee.tasks.find(task => task.taskID === taskID);
            
            if (!task) {
                console.log(`Task with ID ${taskID} does not exist for ${assigneeName}!`);
                continue;
            }

            task.status = newStatus;
        } else if (action === 'Remove Task') {
            const index = Number(tokens[2]);
            const tasksLength = assignee.tasks.length;

            if (index < 0 || index >= tasksLength) {
                console.log('Index is out of range!');
                continue;
            }

            assignee.tasks.splice(index, 1);
        }
    }

    const totalPointsToDo = calculateTotalPoints('ToDo');
    const totalPointsInProgress = calculateTotalPoints('In Progress');
    const totalPointsCodeReview = calculateTotalPoints('Code Review');
    const totalPointsDone = calculateTotalPoints('Done');
    
    console.log(`ToDo: ${totalPointsToDo}pts`);
    console.log(`In Progress: ${totalPointsInProgress}pts`);
    console.log(`Code Review: ${totalPointsCodeReview}pts`);
    console.log(`Done Points: ${totalPointsDone}pts`);


    const totalPointsWithoutDone = totalPointsToDo + totalPointsInProgress + totalPointsCodeReview;

    if (totalPointsDone >= totalPointsWithoutDone) {
        console.log(`Sprint was successful!`);
    } else {
        console.log('Sprint was unsuccessful...');
    }


    function calculateTotalPoints(status) {
        let totalPoints = 0;

        assignees.forEach(assignee => {
            assignee.tasks.filter(t => t.status === status).forEach(task => {
                totalPoints += task.estimatedPoints;
            });
        });

        return totalPoints;
    }
}

solve([
    '4',
    'Kiril:BOP-1213:Fix Typo:Done:1',
    'Peter:BOP-1214:New Products Page:In Progress:2',
    'Mariya:BOP-1215:Setup Routing:ToDo:8',
    'Georgi:BOP-1216:Add Business Card:Code Review:3',
    'Add New:Sam:BOP-1237:Testing Home Page:Done:3',
    'Change Status:Georgi:BOP-1216:Done',
    'Change Status:Will:BOP-1212:In Progress',
    'Remove Task:Georgi:3',
    'Change Status:Mariya:BOP-1215:Done',
]);
