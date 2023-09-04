package pl.kf.itjobsearcher.configuration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleUpdateNotPossible(){
        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(List.of("Update/delete not possible"));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleLackOfPermission(){
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(List.of("You are not allowed to perform this operation"));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleTimeout(){
        return ResponseEntity
                .status(HttpStatus.REQUEST_TIMEOUT)
                .body(List.of("Timeout. Check connection."));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleUnsupportedType(){
        return ResponseEntity
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .body(List.of("This media type is not allowed."));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleServerProblem(){
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(List.of("Service didn't respond."));
    }
}
