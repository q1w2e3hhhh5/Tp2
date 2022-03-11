package ca.cal.persistance;

import ca.cal.model.Book;
import ca.cal.model.Document;

import java.util.List;

public interface BookDao {
    void save(Book book);

    List<Document> findAllBooks();

    List<Document> findBooksByTitle(String title);

    List<Document> findBookByAuthor(String author);

    List<Document> findBooksByYear(int year);

    List<Document> findBooksByType(String genre);
}
