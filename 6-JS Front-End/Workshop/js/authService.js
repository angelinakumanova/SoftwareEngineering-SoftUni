const baseUrl = 'http://localhost:3030/users';

export async function login(email, password) {

    try {
        const response = await fetch(`${baseUrl}/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({email, password})
        });
        
        if (!response.ok) {
            let errorMessage;
            if (response.status === 403) {
                errorMessage = 'Forbidden: Access denied';
            } else if (response.status === 401) {
                errorMessage = 'Unauthorized: Invalid credentials';
            }
            throw new Error(errorMessage);
        }
        
        const result = await response.json();
    
        saveAuthData(result);
    
        return result;
    } catch (error) {
        console.error('Login error:', error);
        throw error; 
        
    }
    
}

export async function register(email, password) {

    try {
        const response = await fetch(`${baseUrl}/register`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({email, password})
        });
    
        if (!response.ok) {
            let errorMessage;
            if (response.status === 409) {
                errorMessage = 'Forbidden: User already exists';
            }
            throw new Error(errorMessage);
        }
    
        const result = await response.json();
    
        
        saveAuthData(result);
    
        return result;
    } catch (error) {
        console.error(error);
        throw error;
    }
    
}

export async function logout() {
    const response = await fetch(`${baseUrl}/logout`, {
        method: 'GET',
        headers: {
            'X-Authorization': getAcessToken()
        }
    });

    removeAuthData();
}

export function isAuthenticated() {
    return !!localStorage.getItem('email')
}

export function getAuthData() {
    const data = {
        userId: localStorage.getItem('userId'),
        email: localStorage.getItem('email'),
        accessToken: localStorage.getItem('accessToken'),
    }

    return data;
}

function saveAuthData(data) {
    localStorage.setItem('email', data.email);
    localStorage.setItem('userId', data._id);
    localStorage.setItem('accessToken', data.accessToken);
}

function removeAuthData() {
    localStorage.removeItem('userId');
    localStorage.removeItem('email');
    localStorage.removeItem('accessToken');
}

function getAcessToken() {
    return localStorage.getItem('accessToken');
}

