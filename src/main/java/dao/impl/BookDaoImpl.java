package dao.impl;

import dao.BookDao;
import model.Author;
import model.Book;
import model.Genre;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public Book add(Book book) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long bookId = (Long) session.save(book);
            book.setId(bookId);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to add book to DB", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Book getByTitle(String title) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Book> bookQuery = session
                    .createQuery("from Book where title = :title", Book.class);
            bookQuery.setParameter("title", title);
            return bookQuery.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(String
                    .format("Can't get book by title '%s'", title), e);
        }
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query<Book> bookQuery = session
                    .createQuery("select b from Book b join fetch b.authors Author"
                            + " where :author member b.authors", Book.class);
            bookQuery.setParameter("author", author);
            return bookQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(String
                    .format("Can't get book by author '%s'", author.getName()), e);
        }
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query<Book> bookQuery = session
                    .createQuery("select b from Book b join fetch b.genre Genre"
                                    + " where b.genre = :genre", Book.class);
            bookQuery.setParameter("genre", genre);
            return bookQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(String
                    .format("Can't get book by genre '%s'", genre.getName()), e);
        }
    }
}
