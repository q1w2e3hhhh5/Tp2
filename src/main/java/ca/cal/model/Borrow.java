package ca.cal.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToOne
    @JoinColumn(name = "c_lient_id")
    private Client cLient;

    @ManyToOne
    @JoinColumn(name = "borrowed_document_id")
    private Document borrowedDocument;
    private LocalDateTime borrowDate = LocalDateTime.now();
    private LocalDateTime returnDate;

}
