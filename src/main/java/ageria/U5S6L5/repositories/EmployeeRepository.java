package ageria.U5S6L5.repositories;

import ageria.U5S6L5.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    boolean existsByEmail(String email);


}


