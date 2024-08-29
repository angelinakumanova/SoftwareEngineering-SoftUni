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
