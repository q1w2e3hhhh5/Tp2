package ca.cal.persistance;

import ca.cal.model.Document;

import java.util.List;

public interface DocumentDao {
    List<Document> findAllDocuments();

    Document findDocumentById(long i);
}
