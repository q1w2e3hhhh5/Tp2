package ca.cal.persistance;

import ca.cal.model.Document;
import ca.cal.model.Dvd;

import java.util.List;

public interface DvdDao {
    void save(Dvd DVD);

    List<Document> findAllDvds();
}
