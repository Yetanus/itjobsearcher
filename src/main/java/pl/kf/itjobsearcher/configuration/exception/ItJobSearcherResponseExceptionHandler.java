package pl.kf.itjobsearcher.configuration.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.kf.itjobsearcher.common.exception.ITJobSearcherBusinessException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@RestControllerAdvice
public class ItJobSearcherResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ITJobSearcherBusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleItJobSearcherBusinessException(ITJobSearcherBusinessException exception, HttpServletRequest request) {
        return ErrorResponse.builder()
                .uuid(UUID.randomUUID())
                .timestamp(LocalDateTime.now())
                .requestPath(request.getRequestURI())
                .message(exception.getMessage())
                .details(Arrays.toString(exception.getStackTrace()))
                .errorCode(String.valueOf(exception.getErrorCode()))
                .build();
    }
    // no error code suggests that this is not business failure
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUnexpectedException(Exception exception, HttpServletRequest request) {
        return ErrorResponse.builder()
                .uuid(UUID.randomUUID())
                .timestamp(LocalDateTime.now())
                .requestPath(request.getRequestURI())
                .message(exception.getMessage())
                .details(Arrays.toString(exception.getStackTrace()))
                .build();
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleLackOfPermission(AccessDeniedException exception, HttpServletRequest request) {
        return ErrorResponse.builder()
                .uuid(UUID.randomUUID())
                .timestamp(LocalDateTime.now())
                .requestPath(request.getRequestURI())
                .message(exception.getMessage())
                .details(Arrays.toString(exception.getStackTrace()))
                .build();
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleProblemAuthentication(AuthenticationException exception, HttpServletRequest request) {
        return ErrorResponse.builder()
                .uuid(UUID.randomUUID())
                .timestamp(LocalDateTime.now())
                .requestPath(request.getRequestURI())
                .message(exception.getMessage())
                .details(Arrays.toString(exception.getStackTrace()))
                .build();
    }
}
