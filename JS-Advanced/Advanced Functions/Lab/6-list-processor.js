function modifyList(input) {
    const collection = [];

    return input.forEach((command) => processCommand(command, collection));
}

function processCommand(command, collection) {
    const [action, param] = command.split(' '); 

    if (actionHandlers[action]) {
        actionHandlers[action](collection, param); 
    }
}

const actionHandlers = {
    'add': (collection, item) => {
        collection.push(item);
    },
    'remove': (collection, item) => {
        for (let i = collection.length - 1; i >= 0; i--) {
            if (collection[i] === item) {
                collection.splice(i, 1);
            }
        }
    },
    'print': (collection) => {
        console.log(collection.join(','));
    }
};


modifyList(['add hello', 'add again', 'remove hello', 'add again', 'print']);
modifyList(['add pesho', 'add george', 'add peter', 'remove peter','print']);
