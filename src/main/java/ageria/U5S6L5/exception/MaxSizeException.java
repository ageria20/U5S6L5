package ageria.U5S6L5.exception;

import org.springframework.web.multipart.MaxUploadSizeExceededException;

public class MaxSizeException extends MaxUploadSizeExceededException {
    public MaxSizeException(Long id) {
        super(id);
    }
}
