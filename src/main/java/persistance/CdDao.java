package persistance;

import model.Cd;
import model.Document;

import java.util.List;

public interface CdDao {
    void save(Cd cd);

    List<Document> findAllCds();
}
