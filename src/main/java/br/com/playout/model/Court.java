package br.com.playout.model;

import br.com.playout.enums.SportType;
import br.com.playout.record.court.CourtCreated;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "court")
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courtId;
    private String name;
    @Enumerated(EnumType.STRING)
    private SportType sport;
    private String location;

    @Column(name = "price_per_hour")
    private BigDecimal pricePerHour;
    private String latitude;
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "userId")
    private User owner;

    public Court() {
    }

    public Court(Long courtId, String name, SportType sport,BigDecimal pricePerHour ,String location, String latitude, String longitude, User user) {
        this.courtId = courtId;
        this.name = name;
        this.sport = sport;
        this.pricePerHour = pricePerHour;
        this.location = location;
        this.owner = user;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Court(CourtCreated courtCreated) {
        this.name = courtCreated.name();
        this.sport = courtCreated.sport();
        this.pricePerHour = courtCreated.pricePerHour();
        this.location = courtCreated.location();
        this.latitude = courtCreated.latitude();
        this.longitude = courtCreated.longitude();
    }

    public Long getCourtId() {
        return courtId;
    }

    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SportType getSport() {
        return sport;
    }

    public void setSport(SportType sport) {
        this.sport = sport;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(BigDecimal pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
