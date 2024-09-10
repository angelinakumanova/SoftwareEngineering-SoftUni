function solve(input) {
    /* "{shelf id} -> {shelf genre}" – create a shelf if the id is not taken.
    "{book title}: {book author}, {book genre}" – if a shelf with that genre exists,
    add the book to the shelf. */

    const shelves = {};

    for (const line of input) {

        if (line.includes('->')) {
            const [shelfIDStr, genre] = line.split(' -> ');
            const shelfID = Number(shelfIDStr);

            if(!shelves.hasOwnProperty(shelfID)) {
                const shelf = {
                    genre,
                    books: [],
                }

                shelves[shelfID] = shelf;
            }
        } else {
            const [bookTitle, info] = line.split(': ');
            const [bookAuthor, bookGenre] = info.split(', ');

            const shelfID = returnShelfIDOrUndefined(bookGenre);

            if (shelfID) {
                const book = {
                    title: bookTitle,
                    author: bookAuthor,
                };

                shelves[shelfID].books.push(book);
            }
        }

    }

    /*"{shelfOne id} {shelf genre}: {books count}
    --> {bookOne title}: {bookOne author}
    --> {bookTwo title}: {bookTwo author}
    …
    {shelfTwo id} {shelf genre}: {books count}
    …" */


    Object.values(shelves)
    .sort((firstShelf, secondShelf) => secondShelf.books.length - firstShelf.books.length)
    .forEach(shelf => {
        const shelfID = Object.entries(shelves).find(([key, value]) => shelf === value)?.[0];
        const booksCount = shelf.books.length;

        console.log(`${shelfID} ${shelf.genre}: ${booksCount}`);
        const sortedBooks = shelf.books.sort((firstBook, secondBook) => firstBook.title.localeCompare(secondBook.title));
        for (const book of shelf.books) {
            console.log(`--> ${book.title}: ${book.author}`);
        }
    })

    function returnShelfIDOrUndefined (bookGenre) {
        for (const [key, value] of Object.entries(shelves)) {
            if (value.genre === bookGenre) {
                return key;
            }
        }
    }
}

solve(['1 -> history', '1 -> action', 'Death in Time: Criss Bell, mystery', '2 -> mystery', '3 -> sci-fi', 'Child of Silver: Bruce Rich, mystery', 'Hurting Secrets: Dustin Bolt, action', 'Future of Dawn: Aiden Rose, sci-fi', 'Lions and Rats: Gabe Roads, history', '2 -> romance', 'Effect of the Void: Shay B, romance', 'Losing Dreams: Gail Starr, sci-fi', 'Name of Earth: Jo Bell, sci-fi', 'Pilots of Stone: Brook Jay, history']);
