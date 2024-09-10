function solve(input) {
    const movies = [];
    
    for (const line of input) {
        const addMovieCommand = 'addMovie';
        const directedByCommand = 'directedBy';
        const onDateCommand = 'onDate';
        
        if (line.includes(addMovieCommand)) {
            const movie = {
                name: line.substring(addMovieCommand.length + 1),
            };
            
            movies.push(movie);
        } else if (line.includes(directedByCommand)) {
            const [name, director] = line.split(` ${directedByCommand} `);
            const movie = movies.find(movie => movie.name === name);
            
            if (movie) {
                movie['director'] = director;
            }
        } else if (line.includes(onDateCommand)) {
            const [name, date] = line.split(` ${onDateCommand} `);

            const movie = movies.find(movie => movie.name === name);
            
            if (movie) {
                movie['date'] = date;
            }
        }
    }

    for (const movie of movies) {

        if (movie.name && movie.date && movie.director) {
            console.log(JSON.stringify(movie));
        }
        
    }
    
}

solve([
    'addMovie Fast and Furious',
    'addMovie Godfather',
    'Inception directedBy Christopher Nolan',
    'Godfather directedBy Francis Ford Coppola',
    'Godfather onDate 29.07.2018',
    'Fast and Furious onDate 30.07.2018',
    'Batman onDate 01.08.2018',
    'Fast and Furious directedBy Rob Cohen'
    ]
    );
