package ageria.U5S6L5.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateBookingDTO(
                               @NotNull(message = "Preference is required to update")
                               String preference) {
}
