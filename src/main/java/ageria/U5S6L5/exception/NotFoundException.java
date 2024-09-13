package ageria.U5S6L5.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Element with id: " + id + " NOT FOUND");
    }
}
