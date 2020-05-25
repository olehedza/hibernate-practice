package service.impl;

import dao.AuthorDao;
import dao.impl.AuthorDaoImpl;
import model.Author;
import service.AuthorService;

public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao = new AuthorDaoImpl();

    @Override
    public Author add(Author author) {
        return authorDao.add(author);
    }
}
