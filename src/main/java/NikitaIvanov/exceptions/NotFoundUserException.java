package NikitaIvanov.exceptions;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(long id) {
        super("Il record con ID " + id + " non è stato trovato!");
    }
}
