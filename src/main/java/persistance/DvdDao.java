package persistance;

import model.Document;
import model.Dvd;

import java.util.List;

public interface DvdDao {
    void save(Dvd DVD);

    List<Document> findAllDvds();
}
