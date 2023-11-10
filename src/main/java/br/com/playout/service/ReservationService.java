package br.com.playout.service;

import br.com.playout.model.Reservation;
import br.com.playout.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public ResponseEntity findAll(){
        List<Reservation> reservations = reservationRepository.findAll();

        return ResponseEntity.ok(reservations);
    }
}
