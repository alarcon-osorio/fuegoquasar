<<<<<<< HEAD
package com.alianza.rebelde.service;

import com.alianza.rebelde.entity.SpaceShip;
import com.alianza.rebelde.excepciones.LocationException;
import com.alianza.rebelde.excepciones.MessageException;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

@Service
public interface TopSecretService {
    public SpaceShip getSpaceShip(RequestEntity requestEntity) throws MessageException, LocationException;
}
=======
package com.alianza.rebelde.service;

import com.alianza.rebelde.entity.SpaceShip;
import com.alianza.rebelde.excepciones.LocationException;
import com.alianza.rebelde.excepciones.MessageException;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

@Service
public interface TopSecretService {
    public SpaceShip getSpaceShip(RequestEntity requestEntity) throws MessageException, LocationException;
}
>>>>>>> fe4517c239007c4df640d8b5283375c16a638e21
