package persistance;

import model.Book;
import model.Document;

import java.util.List;

public interface BookDao {
    void save(Book book);

    List<Document> findAllBooks();
}
