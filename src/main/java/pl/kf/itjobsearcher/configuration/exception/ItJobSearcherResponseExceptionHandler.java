package pl.kf.itjobsearcher.configuration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ItJobSearcherResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleOfferNotFoundException() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(List.of("Offer with given id not exists"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUnexpectedException() {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(List.of("Something is no yes"));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleLackOfPermission() {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(List.of("You are not allowed to perform this operation"));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleProblemAuthentication() {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(List.of("You are not authenticated."));
    }

}
