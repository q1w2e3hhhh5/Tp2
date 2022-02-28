package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dvd extends Document {

    private int TimeLength;


    public Dvd(long id, String title, int publicationYear, String author, String editor, String genre, int timeLength) {
        super(id, title, publicationYear, author, editor, genre);
        TimeLength = timeLength;
    }

}
