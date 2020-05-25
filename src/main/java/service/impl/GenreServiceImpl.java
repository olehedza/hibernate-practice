package service.impl;

import dao.GenreDao;
import dao.impl.GenreDaoImpl;
import model.Genre;
import service.GenreService;

public class GenreServiceImpl implements GenreService {
    private final GenreDao genreDao = new GenreDaoImpl();

    @Override
    public Genre add(Genre genre) {
        return genreDao.add(genre);
    }
}
