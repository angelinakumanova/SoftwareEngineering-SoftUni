import { isAuthenticated, login, logout, register } from "./authService.js";
import { redirect } from "./router-utils.js";
import { getAllSolutions } from "./solutionService.js";
import { html, render } from 'https://unpkg.com/lit@2?module';


export function renderHome() {
    const homeElement = document.getElementById('home');
    homeElement.style.display = 'block';

}

export async function renderSolutions() {
    const solutionsSection = document.getElementById('solutions');
    solutionsSection.style.display = 'block';

    const solutions = await getAllSolutions();

    if (solutions.length < 1) {
        const h2Element = document.createElement('h2');
        h2Element.textContent = 'No Solutions Added.'
        h2Element.setAttribute('id', 'no-solution');

        solutionsSection.appendChild(h2Element);
        return;
    }
    
    const solutionsTemplates = solutions.map(solution => createSolution(solution));

    render(html`${solutionsTemplates}`, solutionsSection);
}

export function renderRegister() {
    const registerSection = document.getElementById('register');
    registerSection.style.display = 'block';

    const formElement = registerSection.querySelector('.register-form');

    formElement.addEventListener('submit', registerHandler);

    async function registerHandler(e) {
        e.preventDefault();

        const formData = new FormData(e.currentTarget);

        const email = formData.get('email');
        const password = formData.get('password');
        const repeatedPassword = formData.get('re-password');

        if (!email || !password || !repeatedPassword || password !== repeatedPassword) {
            window.alert('Fill empty fields!');
            return;
        }

        try {
            await register(email, password);
            formElement.reset();
            redirect('/');
        } catch (error) {
            window.alert(error);
        }
       
    }

}

export function renderLogin() {
    const loginSection = document.getElementById('login');
    loginSection.style.display = 'block';

    const formElement = loginSection.querySelector('.login-form');

    formElement.addEventListener('submit', loginHandler);

    async function loginHandler(e) {
        e.preventDefault();

        const formData = new FormData(e.currentTarget);

        const email = formData.get('email');
        const password = formData.get('password');

        try {
            await login(email, password);
            formElement.reset();
            redirect('/');  
        } catch (error) {
            window.alert(error.message); 
        }
    }
}

export async function renderLogout() {
    await logout();

    redirect('/');
}

export function renderCreate() {
    const createSection = document.getElementById('create');
    createSection.style.display = 'block';

    const formElement = document.querySelector('.create-form');

    formElement.addEventListener('submit', createHandler);

    async function createHandler(e) {
        e.preventDefault();

        const formData = new FormData(e.currentTarget);

        const solutionType = formData.get('type');
        const imageUrl = formData.get('image-url');
        const description = formData.get('description');
        const moreInfo = formData.get('more-info');

    }
}

export function renderEdit() {
    const editSection = document.getElementById('edit');
    editSection.style.display = 'block';

}

export function renderDetails() {
    const detailsSection = document.getElementById('details');
    detailsSection.style.display = 'block';
}

export function renderHeader() {
    const headerElement = document.querySelector('#wrapper > header');
    const userNavigation = headerElement.querySelector('.user');
    const guestNavigation = headerElement.querySelector('.guest');

    if (isAuthenticated()) {
        guestNavigation.style.display = 'none';
        userNavigation.style.display = '';
    } else {
        guestNavigation.style.display = '';
        userNavigation.style.display = 'none';
    }
}

function createSolution(data) {
    const template = (data) => html`
    <div class="solution">
        <img src="${data.imageUrl}" alt="example1" />
        <div class="solution-info">
        <h3 class="type">${data.type}</h3>
        <p class="description">
            ${data.description}
        </p>
        <a class="details-btn" href="/solutions/${data._id}/details">Learn More</a>
        </div>
    </div>
    `;
    
    return template(data);
}
