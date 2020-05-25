import model.Author;
import model.Book;
import model.Genre;
import service.AuthorService;
import service.BookService;
import service.GenreService;
import service.impl.AuthorServiceImpl;
import service.impl.BookServiceImpl;
import service.impl.GenreServiceImpl;

import java.util.List;

public class Main {
    private static final AuthorService authorService = new AuthorServiceImpl();
    private static final GenreService genreService = new GenreServiceImpl();
    private static final BookService bookService = new BookServiceImpl();

    public static void main(String[] args) {
        Author gaiman = new Author();
        gaiman.setName("Neil Gaiman");
        gaiman = authorService.add(gaiman);
        Author pratchett = new Author();
        pratchett.setName("Terry Pratchett");
        pratchett = authorService.add(pratchett);
        Author handler = new Author();
        handler.setName("Daniel Handler");
        handler = authorService.add(handler);
        Author kalman = new Author();
        kalman.setName("Maira Kalman");
        kalman = authorService.add(kalman);
        Author tolkien = new Author();
        tolkien.setName("John Tolkien");
        tolkien = authorService.add(tolkien);
        Author clarke = new Author();
        clarke.setName("Arthur Clarke");
        clarke = authorService.add(clarke);

        Genre romance = new Genre();
        romance.setName("romance");
        romance = genreService.add(romance);
        Genre fantasy = new Genre();
        fantasy.setName("fantasy");
        fantasy = genreService.add(fantasy);
        Genre scienceFiction = new Genre();
        scienceFiction.setName("science-fiction");
        scienceFiction = genreService.add(scienceFiction);

        Book brokeUp = new Book();
        brokeUp.setTitle("Why We Broke Up");
        brokeUp.setAuthors(List.of(handler, kalman));
        brokeUp.setGenre(romance);
        bookService.add(brokeUp);
        Book paradise = new Book();
        paradise.setTitle("The Fountain of Paradise");
        paradise.setAuthors(List.of(clarke));
        paradise.setGenre(scienceFiction);
        bookService.add(paradise);
        Book lordOfRings = new Book();
        lordOfRings.setTitle("Lord of Rings");
        lordOfRings.setAuthors(List.of(tolkien));
        lordOfRings.setGenre(fantasy);
        bookService.add(lordOfRings);
        Book goodOmens = new Book();
        goodOmens.setTitle("Good Omens");
        goodOmens.setAuthors(List.of(gaiman, pratchett));
        goodOmens.setGenre(fantasy);
        bookService.add(goodOmens);

        Book bookFromDB = bookService.getByTitle("Good Omens");
        System.out.println(bookFromDB);

        List<Book> bookList1 = bookService.getBooksByGenre(fantasy);
        bookList1.forEach(System.out::println);

        List<Book> bookList2 = bookService.getBooksByAuthor(clarke);
        bookList2.forEach(System.out::println);
    }
}
