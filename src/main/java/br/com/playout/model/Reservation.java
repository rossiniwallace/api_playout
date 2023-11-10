package br.com.playout.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;
    @ManyToOne
    @JoinColumn(name = "court_id", referencedColumnName = "courtId")
    private Court court;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "userId")
    private User client;
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "end_time")
    private LocalDateTime endTime;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    public Reservation(){

    }

    public Reservation(Long reservationId, Court court, User user, LocalDateTime startTime, LocalDateTime endTime, BigDecimal totalAmount) {
        this.reservationId = reservationId;
        this.court = court;
        this.client = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalAmount = totalAmount;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
