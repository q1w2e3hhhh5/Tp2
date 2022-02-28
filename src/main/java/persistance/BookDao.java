package persistance;

import model.Book;

import java.util.List;

public interface BookDao {
    void save(Book book);

    List<Book> findAllBooks();
}
