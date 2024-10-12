function extensibleObject() { 
    const obj = {
        extend: function(template) {
            for (const key in template) {
                if (template.hasOwnProperty(key)) {
                    if (typeof template[key] === 'function') {
                        Object.getPrototypeOf(obj)[key] = template[key];
                    } else {
                        obj[key] = template[key];
                    }
                }
            }
        }
    };

    return obj;
} 
const myObj = extensibleObject(); 


const template = { 
    extensionMethod: function () {}, 
    extensionProperty: 'someString' 
} 
myObj.extend(template); 

