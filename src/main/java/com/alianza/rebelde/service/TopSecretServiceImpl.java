package com.alianza.rebelde.service;

import com.alianza.rebelde.entity.SpaceShip;
import com.alianza.rebelde.entity.Position;
import com.alianza.rebelde.entity.SatellitalPosition;
import com.alianza.rebelde.entity.Transport;
import com.alianza.rebelde.excepciones.LocationException;
import com.alianza.rebelde.excepciones.MessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TopSecretServiceImpl implements TopSecretService {

    @Autowired
    private LocationService locationService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private Environment environment;

    @Override
    public SpaceShip getSpaceShip(RequestEntity requestEntity) throws MessageException, LocationException {
        SatellitalPosition satellitalPosition = (SatellitalPosition)requestEntity.getBody();
        if(satellitalPosition.getMessages().size() < 2) {
            throw new MessageException("Número de mensajes insuficientes");
        }
        String message = messageService.getMessage(satellitalPosition.getMessages());

        upPosition(satellitalPosition);
        if((satellitalPosition.getPositions().length < 2) || (satellitalPosition.getPositions().length < 2)) {
            throw new LocationException("Número posicion o distancias insuficientes");
        }
        double [] points = locationService.getLocation(satellitalPosition.getPositions(), satellitalPosition.getDistances());
        Position position = new Position(points);
        return new Transport(position, message);
    }

    public void upPosition(SatellitalPosition satellitalPosition){
        if(satellitalPosition.getPositions()[0] == null) {
            int numberSatellites = Integer.parseInt(environment.getProperty("number.satellites"));
            double[][] pointList = new double[numberSatellites][];
            String[] satellitePosition;
            for (int i = 0; i < satellitalPosition.getSatellites().size(); i++) {
                satellitePosition = environment.getProperty("satellites." + i + ".position").split(",");
                pointList[i] = Arrays.stream(satellitePosition)
                        .map(Double::valueOf)
                        .mapToDouble(Double::doubleValue)
                        .toArray();
            }
            satellitalPosition.setPositions(pointList);
        }
    }

}
