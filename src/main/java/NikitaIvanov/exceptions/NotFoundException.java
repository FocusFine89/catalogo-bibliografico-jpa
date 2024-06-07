package NikitaIvanov.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        super("Il record con ISBN " + id + " non è stato trovato!");
    }
}
