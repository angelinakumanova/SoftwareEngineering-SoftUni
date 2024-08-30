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

export async function editSolution(solution, newSolution) {
    try {
        const response = await fetch(`${baseUrl}/${solution._id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                'X-Authorization': getAuthData().accessToken,
            },
            body: JSON.stringify(newSolution),
        });

        const result = await response.json();

        
    } catch (error) {
        console.error(error);
        throw error;
    }
}

export async function deleteSolution(solutionId) {
    try {
        const response = await fetch(`${baseUrl}/${solutionId}`, {
            method: 'DELETE',
            headers: {
                'X-Authorization': getAuthData().accessToken,
            }
        })

        if (!response.ok) {
            const errorMessage = `Error: ${response.status} - ${response.statusText}`;
            throw new Error(errorMessage);
        }
    } catch (error) {
        console.error('An error occurred while deleting the solution:', error);
        throw error;
    }
}

export async function getOne(solutionId) {
    const response = await fetch(`${baseUrl}/${solutionId}`);
    const result = await response.json();

    return result;
}
