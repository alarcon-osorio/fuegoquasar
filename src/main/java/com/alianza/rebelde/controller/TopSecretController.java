package com.alianza.rebelde.controller;

import com.alianza.rebelde.entity.SatellitalPosition;
import com.alianza.rebelde.excepciones.LocationException;
import com.alianza.rebelde.excepciones.MessageException;
import com.alianza.rebelde.service.TopSecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "api")
public class TopSecretController {

    @Autowired
    private TopSecretService topSecretService;

    @PostMapping("/topsecret")
    public ResponseEntity topSecret(RequestEntity<SatellitalPosition> requestEntity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(topSecretService.getSpaceShip(requestEntity));
        }catch (MessageException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }catch (LocationException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
