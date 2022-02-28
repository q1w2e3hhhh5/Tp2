package model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(exclude = "bookings")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String role;



    /*    @ManyToMany(mappedBy = "passengerBookings",fetch = FetchType.EAGER)
    private List<Booking> bookings = new ArrayList<>();*/

}
