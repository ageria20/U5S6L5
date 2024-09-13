package ageria.U5S6L5.services;


import ageria.U5S6L5.dto.BookingDTO;
import ageria.U5S6L5.dto.UpdateBookingDTO;
import ageria.U5S6L5.entities.Booking;
import ageria.U5S6L5.entities.Employee;
import ageria.U5S6L5.entities.Travel;
import ageria.U5S6L5.exception.NotFoundException;
import ageria.U5S6L5.repositories.BookingRepository;
import ageria.U5S6L5.repositories.EmployeeRepository;
import ageria.U5S6L5.repositories.TraveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    TravelService travelService;

    // GET w/ PAGES
    public Page<Booking> getAllBookings(int pages, int size, String sortBy){
        Pageable pageable = PageRequest.of(pages, size, Sort.by(sortBy));
        return this.bookingRepository.findAll(pageable);
    }

    // GET BY ID
    public Booking findByBookingId(Long id){
        return this.bookingRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    // POST
    public Booking saveBooking(BookingDTO body){
        Travel travelFromDB = this.travelService.findById(body.travelId());
        Employee employeeFromDb = this.employeeService.findById(body.employeeId());
        Booking newBooking = new Booking(travelFromDB, employeeFromDb, body.bookingDate(), body.preference());
        return this.bookingRepository.save(newBooking);
    }

    // PUT
    public Booking findByIdAndUpdate(Long id, UpdateBookingDTO body){
        Booking bookingFromDB = this.findByBookingId(id);
        bookingFromDB.setBookingDate(body.bookingDate());
        bookingFromDB.setPreference(body.preference());
        return this.bookingRepository.save(bookingFromDB);
    }

    // DELETE
    public void findByDelete(Long id){
        Booking bookingToDelete = this.findByBookingId(id);
        this.bookingRepository.delete(bookingToDelete);
    }
}
