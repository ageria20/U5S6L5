package ageria.U5S6L5.dto;

import ageria.U5S6L5.enums.TravelStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record TravelDTO(@NotEmpty(message = "Destination is required")
                        String destination,
                        @NotEmpty(message = "Date is required")
                        LocalDateTime date,
                        @NotEmpty(message = "Travel status is required")
                        TravelStatus travelStatus) {
}
