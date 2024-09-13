package ageria.U5S6L5.entities;

import ageria.U5S6L5.enums.TravelStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Travel {

    @Id
    @GeneratedValue
    private long id;
    private String destination;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private TravelStatus travelStatus;
}
