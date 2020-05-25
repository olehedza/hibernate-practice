package service;

import model.Author;
import model.Book;
import model.Genre;
import java.util.List;

public interface BookService {
    Book add(Book book);

    Book getByTitle(String title);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getBooksByGenre(Genre genre);
}
