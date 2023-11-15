package pl.kf.itjobsearcher.common.exception;

import lombok.Getter;

import java.util.List;

/**
 * The exception class that indicates that a business error has occurred while executing the logic.
 */
@Getter
public class ITJobSearcherBusinessException extends ITJobSearcherException {

    /**
     * The error code is a unique error identifier defined per error situation.
     */
    private final ITJobSearcherErrorCode errorCode;

    /**
     * User messages that allow an accurate understanding of the error. Messages are passed to client applications
     * in error response, so they should be internationalized if necessary.
     */
    private final List<String> userMessages;


    public ITJobSearcherBusinessException(ITJobSearcherErrorCode errorCode, List<String> userMessages, Throwable cause) {
        super(errorCode.errorMessage(), cause);
        this.errorCode = errorCode;
        this.userMessages = userMessages;
    }
}
