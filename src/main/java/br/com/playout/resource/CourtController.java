package br.com.playout.resource;

import br.com.playout.model.User;
import br.com.playout.record.court.CourtValidation;
import br.com.playout.service.CourtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/courts")
public class CourtController {

    @Autowired
    CourtService courtService;

    @GetMapping
    public ResponseEntity findAll(
            @AuthenticationPrincipal User user,
            @PageableDefault(size = 10) Pageable pageable){
        return courtService.findAll(pageable);
    }

    @GetMapping("/{courtId}")
    public ResponseEntity findById(
            @PathVariable Long courtId
    ){
        return courtService.findById(courtId);
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(
            @AuthenticationPrincipal User user,
            @RequestBody @Valid CourtValidation body){
        return courtService.create(body,user.getUserId());
    }

    @PutMapping("/{courtId}")
    @Transactional
    public ResponseEntity update(
            @AuthenticationPrincipal User user,
            @PathVariable Long courtId,
            @RequestBody @Valid Optional<CourtValidation> body){

        return courtService.update(body,courtId,user.getUserId());
    }

    @DeleteMapping("/{courtId}")
    public ResponseEntity delete(
            @PathVariable Long courtId
    ){
        return courtService.delete(courtId);
    }

}
