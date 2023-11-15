package pl.kf.itjobsearcher.configuration.exception;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record ErrorResponse(
        UUID uuid,
        LocalDateTime timeStamp,
        String requestPath,
        String message,
        String details
) {
}
