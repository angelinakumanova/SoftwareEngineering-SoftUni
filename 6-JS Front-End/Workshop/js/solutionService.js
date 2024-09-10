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

export async function addLike(solutionId) {
    try {
        const response = await fetch('http://localhost:3030/data/likes', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-Authorization': getAuthData().accessToken,
            },
            body: JSON.stringify({ solutionId })
        });

        if (!response.ok) {
            throw new Error('Failed to like the solution.');
        }

        const newRecord = await response.json();
        
        return newRecord;
    } catch (error) {
        console.error('Error liking the solution:', error);
        alert('There was a problem liking this solution.');
    }
}

export async function userHasLiked(solutionId, userId) {
    try {
        const response = await fetch(`http://localhost:3030/data/likes?where=solutionId%3D%22${solutionId}%22%20and%20_ownerId%3D%22${userId}%22&count`);

        if (!response.ok) {
            throw new Error('Failed to check if the user has liked the solution.');
        }

        const likeCount = await response.json();
        return likeCount > 0;
    } catch (error) {
        console.error('Error checking if the user has liked the solution:', error);
        return false;
    }
}

export async function getLikesCount(solutionId) {
    try {
        const response = await fetch(`http://localhost:3030/data/likes?where=solutionId%3D%22${solutionId}%22&distinct=_ownerId&count`);

        if (!response.ok) {
            throw new Error('Failed to fetch the likes count.');
        }

        const likeCount = await response.json();
        return likeCount;
    } catch (error) {
        console.error('Error fetching the likes count:', error);
        return 0; 
    }
}

export async function getOne(solutionId) {
    const response = await fetch(`${baseUrl}/${solutionId}`);
    const result = await response.json();

    return result;
}
