package br.cefsa.edu.br.hotelaria.exception;

public class DataInvalidaException extends Exception {

    public DataInvalidaException() {
        super();
    }

    public DataInvalidaException(String message) {
        super(message);
    }

    public DataInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataInvalidaException(Throwable cause) {
        super(cause);
    }

    public DataInvalidaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
