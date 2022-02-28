package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private int publicationYear;
    private String author;  //can it be author for dvd and cd?
    private String editor;
    private String genre;   //rock nd roll, adventure, fiction, poetry




/*
    @Override
    public String toString() {
        return "\n" +
                "\t\t" + "Year Of Publication : " + publicationYear + "\n" +
                "\t\t" + "Is Borrowed : " + isBorrowed + "\n";
    }
*/

}
