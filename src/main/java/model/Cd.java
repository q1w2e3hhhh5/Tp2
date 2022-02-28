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
public class Cd extends Document {
    private int TimeLength; //in min


    @Builder
    public Cd(long id, String title, int publicationYear, String author, String editor, String genre, int timeLength) {
        super(id, title, publicationYear, author, editor, genre);
        TimeLength = timeLength;
    }

}