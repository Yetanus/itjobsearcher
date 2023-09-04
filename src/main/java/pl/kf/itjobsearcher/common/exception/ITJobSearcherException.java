package pl.kf.itjobsearcher.common.exception;

import lombok.Getter;

import java.util.UUID;

/**
 * Base class for all application specific exceptions in IT-Job searcher application.
 */
@Getter
public abstract class ITJobSearcherException extends RuntimeException {

    /** On creation each {@link ITJobSearcherException} it generates unique identifier. */
    private final UUID uuid = UUID.randomUUID();

    ITJobSearcherException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
        return "[" + uuid + "]" + super.toString();
    }
}
