package model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book extends Document {

    private int nbPages;
    private String type;   //manual, manga, school book

    @Builder
    public Book(long id, String title, int publicationYear, String author, String editor,
                String genre, int nbPages, String type, String documentType) {
        super(id, title, publicationYear, author, editor, genre,documentType);
        this.nbPages = nbPages;
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\t\t" + "Number of Pages : " + nbPages + "\n" +
                "\t\t" + "Type : " + type + "\n";
    }
}

