package pl.kf.itjobsearcher.common.exception;

import java.io.Serializable;

/**
 * The base interface for all unique error codes defined per error case. The interface
 * should be implemented be each business module that throws {@link ITJobSearcherBusinessException}
 * by an {@link Enum} containing specific error code for the module.
 */
public interface ITJobSearcherErrorCode extends Serializable {

    String code();
    String description();

    default String errorMessage() {
        return "Error code: " + code() + ", Description: " + code();
    }
}
