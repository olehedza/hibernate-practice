package dao.impl;

import dao.GenreDao;
import model.Genre;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class GenreDaoImpl implements GenreDao {
    @Override
    public Genre add(Genre genre) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long genreId = (Long) session.save(genre);
            genre.setId(genreId);
            transaction.commit();
            return genre;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to add genre to DB", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
