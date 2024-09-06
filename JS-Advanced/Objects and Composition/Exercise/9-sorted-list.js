function createSortedList() {
    const items = [];
    const getLength = () => items.length;
    
    return {
        add: (element) => {
            items.push(element)
            items.sort((a, b) => a - b);
        },
        remove: (index) => {
            if (index >= 0 && index < items.length) {
                items.splice(index, 1);
            }
        },
        get: (index) => {
            if (index >= 0 && index < items.length) {
                return items[index];
            }
        },
        get size() {
            return items.length;  
        }
    };
}

// •	add(element) - adds a new element to the collection
// •	remove(index) - removes the element at position index
// •	get(index) - returns the value of the element at position index
// •	size - number of elements stored in the collection

const list = createSortedList();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1)); 
list.remove(1);
console.log(list.get(1));
