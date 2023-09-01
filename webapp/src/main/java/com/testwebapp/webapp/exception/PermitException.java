package com.testwebapp.webapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PermitException extends ResponseStatusException {
        public PermitException() {
                super(HttpStatus.BAD_REQUEST, "Permitnumber is not valid");
        }
}
