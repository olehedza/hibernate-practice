package dao.impl;

import dao.AuthorDao;
import model.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class AuthorDaoImpl implements AuthorDao {
    @Override
    public Author add(Author author) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long authorId = (Long) session.save(author);
            author.setId(authorId);
            transaction.commit();
            return author;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to add author to DB", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
