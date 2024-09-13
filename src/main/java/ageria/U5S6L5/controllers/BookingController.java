package ageria.U5S6L5.controllers;


import ageria.U5S6L5.dto.BookingDTO;
import ageria.U5S6L5.dto.UpdateBookingDTO;
import ageria.U5S6L5.entities.Booking;
import ageria.U5S6L5.exception.BadRequestException;
import ageria.U5S6L5.services.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    // GET W/ PAGES
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Booking> findAllBooking(@RequestParam(defaultValue = "0") int pages,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(defaultValue = "id") String sortBy){
        return this.bookingService.getAllBookings(pages, size, sortBy);
    }

    // GET w/ ID
    @GetMapping("/{bookingId}")
    @ResponseStatus(HttpStatus.OK)
    public Booking findBookingById(@PathVariable Long bookingId){
        return this.bookingService.findByBookingId(bookingId);
    }

    // POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Booking createBooking(@RequestBody BookingDTO body, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String msg = (String) bindingResult.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.joining());
            throw new BadRequestException(msg);
        }
        return this.bookingService.saveBooking(body);
    }

//PUT
    @PutMapping("/bookingId")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking updateBooking(@RequestBody UpdateBookingDTO body, @PathVariable Long bookingId){
        
    }


    // DELETE
    @DeleteMapping("/{bookingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteBooking(@PathVariable Long bookingId){
                this.bookingService.findByDelete(bookingId);
        return "BOOKING DELETED CORRECTLY";
    }

}
