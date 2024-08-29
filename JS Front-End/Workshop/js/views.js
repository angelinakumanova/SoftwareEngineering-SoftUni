import { isAuthenticated, login, logout, register } from "./authService.js";
import { redirect } from "./router-utils.js";

export function renderHome() {
    const homeElement = document.getElementById('home');
    homeElement.style.display = 'block';

}

export function renderSolutions() {
    const solutionsSection = document.getElementById('solutions');
    solutionsSection.style.display = 'block';
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
