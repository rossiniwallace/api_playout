package br.com.playout.service;

import br.com.playout.model.Court;
import br.com.playout.model.User;
import br.com.playout.record.court.CourtValidation;
import br.com.playout.record.court.CourtDTO;
import br.com.playout.repository.CourtRepository;
import br.com.playout.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CourtService {

    @Autowired
    CourtRepository courtRepository;

    @Autowired
    UserRepository userRepository;

    public ResponseEntity findAll(Pageable pageable){
      Page<Court> courts = courtRepository.findAll(pageable);

      List<CourtDTO> dtos = courts.stream().map(CourtDTO::new).collect(Collectors.toList());

      return ResponseEntity.ok(dtos);
    }

    public ResponseEntity findById(Long courtId){

        Court court = courtRepository.getReferenceById(courtId);

        CourtDTO courtDTO = new CourtDTO(court);

        return ResponseEntity.ok(courtDTO);

    }

    public ResponseEntity create(CourtValidation courtCreated, Long userId){

        User user = userRepository.getReferenceById(userId);

        Court object = new Court(courtCreated);
        object.setOwner(user);

        Court court = courtRepository.save(object);

        CourtDTO courtDTO = new CourtDTO(court);

        return ResponseEntity.ok(courtDTO);
    }

    public ResponseEntity update(Optional<CourtValidation> courtUpdate, Long courtId , Long userId){

        Optional<Court> optional = courtRepository.findById(courtId);

        if(optional.isPresent()){
            Court court = optional.get();

            BeanUtils.copyProperties(courtUpdate.get(),court,"courtId");

            courtRepository.save(court);

            CourtDTO courtDTO = new CourtDTO(court);

            return ResponseEntity.ok(courtDTO);
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity delete(Long courtId){
        courtRepository.deleteById(courtId);

        return ResponseEntity.ok("");
    }

}
