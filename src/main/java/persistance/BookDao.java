package persistance;

import model.Book;
import model.Document;

import java.util.List;

public interface BookDao {
    void save(Book book);

    List<Document> findAllBooks();

    List<Document> findBooksByTitle(String title);

    List<Document> findBookByAuthor(String author);

    List<Document> findBooksByYear(int year);

    List<Document> findBooksByGenre(String genre);
}
