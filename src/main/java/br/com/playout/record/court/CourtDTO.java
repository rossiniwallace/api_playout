package br.com.playout.record.court;

import br.com.playout.enums.SportType;
import br.com.playout.model.Court;
import br.com.playout.record.users.OwnerDTO;

import java.math.BigDecimal;

public record CourtDTO(
        Long courtId,
        String name,
        SportType sport,
        String location,
        BigDecimal pricePerHour,
        String latitude,
        String longitude,
        OwnerDTO owner
) {
    public CourtDTO(Court court) {
        this(
            court.getCourtId(),
            court.getName(),
            court.getSport(),
            court.getLocation(),
            court.getPricePerHour(),
            court.getLatitude(),
            court.getLongitude(),
            new OwnerDTO(court.getOwner())
        );
    }
}
