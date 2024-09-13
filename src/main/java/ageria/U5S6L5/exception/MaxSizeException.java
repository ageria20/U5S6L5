package ageria.U5S6L5.exception;

import com.cloudinary.api.exceptions.BadRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

public class MaxSizeException extends MaxUploadSizeExceededException {
    public MaxSizeException(Long fileSize) {
        super(fileSize);
    }
}
