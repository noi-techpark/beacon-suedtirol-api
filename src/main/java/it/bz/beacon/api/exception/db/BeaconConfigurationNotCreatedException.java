package it.bz.beacon.api.exception.db;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Beacon configuration not created")
public class BeaconConfigurationNotCreatedException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}
