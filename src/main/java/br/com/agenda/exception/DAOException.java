package br.com.agenda.exception;

public class DAOException extends RuntimeException {
    public DAOException(String message) {
        super("Ocorreu um erro no DAO:\n" + message);
    }

    public DAOException(String message, Throwable cause) {
        super("Ocorreu um erro no DAO:\n" + message, cause);
    }
}
