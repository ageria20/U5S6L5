package ageria.U5S6L5.dto;

import ageria.U5S6L5.entities.Employee;
import ageria.U5S6L5.entities.Travel;
import ageria.U5S6L5.enums.TravelStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record BookingDTO(Travel travelId,
                         Employee employeeId,
                         @NotNull(message = "The booking Date is required")
                         LocalDateTime bookingDate,
                         @NotEmpty(message = "The preference is required")
                         String preference) {
}
