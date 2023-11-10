package br.com.playout.resource;

import br.com.playout.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping
    public ResponseEntity findAll(){
        return reservationService.findAll();
    }

}
