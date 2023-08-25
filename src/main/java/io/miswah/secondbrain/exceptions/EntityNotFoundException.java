package io.miswah.secondbrain.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class EntityNotFoundException extends ResponseStatusException {
    public EntityNotFoundException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
