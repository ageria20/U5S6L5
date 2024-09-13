package ageria.U5S6L5.dto;

import ageria.U5S6L5.enums.TravelStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TravelDTO(@NotNull(message = "Destination is required")
                        String destination,
                        @NotNull(message = "Date is required")
                        LocalDate travelDate,
                        @NotNull(message = "Travel status is required")
                        TravelStatus travelStatus) {
}
