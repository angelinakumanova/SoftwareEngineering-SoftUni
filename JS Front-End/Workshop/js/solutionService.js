import { getAuthData } from "./authService.js";

const baseUrl = 'http://localhost:3030/data/solutions';

export async function getAllSolutions() {
    try {
        const response = await fetch(baseUrl);

        const result = response.json();
    
        return result;
    } catch (error) {
        console.error('Failed to fetch data:', error);
        throw error;
    }
    
}

export async function addSolution(solution) {

    try {
        const response = await fetch(baseUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-Authorization': getAuthData().accessToken,
            },
            body: JSON.stringify(solution),
        });

        
    } catch (error) {
        console.error(error);
        throw error;
    }
    
}
