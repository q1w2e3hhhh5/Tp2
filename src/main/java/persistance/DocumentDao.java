package persistance;

import model.Document;
import model.Employee;

import java.util.List;

public interface DocumentDao {
    List<Document> findAllDocuments();
}
