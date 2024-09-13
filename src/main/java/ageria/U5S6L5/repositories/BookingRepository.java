package ageria.U5S6L5.repositories;

import ageria.U5S6L5.entities.Booking;
import ageria.U5S6L5.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    boolean existsByBookingDateAndEmployeeId( LocalDate travelDate, Long employee);


    boolean existsByEmployeeAndTravelDate(Employee employee, LocalDate travelDate);
}
