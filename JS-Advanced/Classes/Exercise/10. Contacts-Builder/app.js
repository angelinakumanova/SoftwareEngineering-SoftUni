class Contact {

    constructor(firstName, lastName, phone, email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.online = false;
        this.titleDivElement = null;
    }

    set online(value) {
        this._online = value;
        if (this.titleDivElement) {
            if (value) {
                this.titleDivElement.classList.add('online');
            } else {
                this.titleDivElement.classList.remove('online');
            }
        }
    }

    get online() {
        return this._online;
    }
    
    render(parentName) {
        const parentElement = document.getElementById(parentName);
        const contactInfoBox = this.#createContactInfoBox();
        parentElement.appendChild(contactInfoBox);
    }
    
    #createContactInfoBox() {
        const articleElement = document.createElement('article');
    
        const titleDivElement = document.createElement('div');
        titleDivElement.classList.add('title');
        titleDivElement.textContent = `${this.firstName} ${this.lastName}`;

        this.titleDivElement = titleDivElement;
    
        const titleDivButton = document.createElement('button');
        titleDivButton.textContent = '\u2139';
        
        titleDivElement.appendChild(titleDivButton);
        
    
        const infoDivElement = document.createElement('div');
        infoDivElement.classList.add('info');
        infoDivElement.style.display = 'none';
    
        const phoneSpanElement = document.createElement('span'); 
        phoneSpanElement.textContent = `\u260E ${this.phone}`;
        infoDivElement.appendChild(phoneSpanElement);
    
        const emailSpanElement = document.createElement('span'); 
        emailSpanElement.textContent = `\u2709 ${this.email}`;
        infoDivElement.appendChild(emailSpanElement);
    
        titleDivButton.addEventListener('click', () => {
             infoDivElement.style.display = infoDivElement.style.display === 'none' ? 'block' : 'none';
        });
        articleElement.appendChild(titleDivElement);
        articleElement.appendChild(infoDivElement);
        
        return articleElement;
    }
}


let contacts = [
    new Contact("Ivan", "Ivanov", "0888 123 456", "i.ivanov@gmail.com"),
    new Contact("Maria", "Petrova", "0899 987 654", "mar4eto@abv.bg"),
    new Contact("Jordan", "Kirov", "0988 456 789", "jordk@gmail.com")
];
contacts.forEach(c => c.render('main'));

setTimeout(() => contacts[1].online = true, 2000);
