package IteratorsAndComparators.Lab;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    class LibraryIterator implements Iterator<Book> {

        private int pos = 0;
        @Override
        public boolean hasNext() {
            return pos < books.length;
        }

        @Override
        public Book next() {
            return books[pos++];
        }
    }
}
