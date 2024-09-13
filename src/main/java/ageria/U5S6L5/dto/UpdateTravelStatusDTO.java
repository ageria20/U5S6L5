package ageria.U5S6L5.dto;

import ageria.U5S6L5.enums.TravelStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateTravelStatusDTO(@NotNull(message = "Travel status is required")
                                    TravelStatus travelStatus) {
}
