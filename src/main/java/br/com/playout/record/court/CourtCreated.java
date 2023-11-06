package br.com.playout.record.court;

import br.com.playout.enums.SportType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CourtCreated(
        @NotBlank
        String name,
        @NotNull
        SportType sport,
        @NotBlank
        String location,
        @NotBlank
        String latitude,
        @NotNull
        @DecimalMin("0.0")
        BigDecimal pricePerHour,
        @NotBlank
        String longitude,
        Integer ownerId
) {
}
