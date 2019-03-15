package it.bz.beacon.api.exception.db;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Beacon identifier is not valid.")
public class InvalidBeaconIdentifierException extends RuntimeException {
}
