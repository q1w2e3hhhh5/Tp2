package ca.cal.model;

import lombok.AllArgsConstructor;
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
    private String author;
    private String editor;
    private String type;   //rock nd roll, adventure, fiction, poetry
    private String documentType;


    @Override
    public String toString() {
        return "\n" +
                "\t" + "ID : " + id + "\n" +
                "\t" + "Title : " + title + "\n" +
                "\t\t" + "Document Type : " + documentType + "\n" +
                "\t\t" + "Author : " + author + "\n" +
                "\t\t" + "Editor : " + editor + "\n" +
                "\t\t" + "Publication Year : " + publicationYear + "\n" +
                "\t\t" + "Genre : " + type + "\n";
    }
}

