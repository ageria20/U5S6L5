package ageria.U5S6L5.repositories;


import ageria.U5S6L5.entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TraveRepository extends JpaRepository<Travel, Long> {

    boolean existsByDestination(String destination);

}
