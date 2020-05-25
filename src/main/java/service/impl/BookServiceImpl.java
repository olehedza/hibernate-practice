package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import model.Author;
import model.Book;
import model.Genre;
import service.BookService;
import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public Book add(Book book) {
        return bookDao.add(book);
    }

    @Override
    public Book getByTitle(String title) {
        return bookDao.getByTitle(title);
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return bookDao.getBooksByAuthor(author);
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        return bookDao.getBooksByGenre(genre);
    }
}
