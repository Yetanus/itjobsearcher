package pl.kf.itjobsearcher.common.exception;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public record ErrorResponse(
        List<String> userMessage,
        //Error message for developer
        String errorDescription,
        String requestPath,
        String errorCode,
        LocalDateTime errorTimestamp,
        //Log data, whole exception with stack trace
        String errorDetails,
        UUID errorId
) { }
