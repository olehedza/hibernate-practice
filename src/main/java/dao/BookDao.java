package dao;

import model.Author;
import model.Book;
import model.Genre;
import java.util.List;

public interface BookDao {
    Book add(Book book);

    Book getByTitle(String title);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getBooksByGenre(Genre genre);
}
