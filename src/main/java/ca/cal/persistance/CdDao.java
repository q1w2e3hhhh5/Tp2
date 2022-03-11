package ca.cal.persistance;

import ca.cal.model.Cd;
import ca.cal.model.Document;

import java.util.List;

public interface CdDao {
    void save(Cd cd);

    List<Document> findAllCds();
}
