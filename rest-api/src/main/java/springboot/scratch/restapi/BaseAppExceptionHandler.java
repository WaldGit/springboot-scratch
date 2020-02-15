package springboot.scratch.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public abstract class BaseAppExceptionHandler {

    @ExceptionHandler(value = {ControllerException.class})
    public ResponseEntity<Object> handleControllerException(UserControllerException ex, WebRequest request) {

        String errorMsg = ex.getLocalizedMessage() != null ? ex.getLocalizedMessage() : ex.toString();

        return new ResponseEntity<>("<ControllerException> " + errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {

        String errorMsg = ex.getLocalizedMessage() != null ? ex.getLocalizedMessage() : ex.toString();

        return new ResponseEntity<>("<RuntimeException> " + errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {

        String errorMsg = ex.getLocalizedMessage() != null ? ex.getLocalizedMessage() : ex.toString();

        return new ResponseEntity<>("<Exception> " + errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Throwable.class})
    public ResponseEntity<Object> handleThrowable(Throwable ex, WebRequest request) {

        String errorMsg = ex.getLocalizedMessage() != null ? ex.getLocalizedMessage() : ex.toString();

        return new ResponseEntity<>("<Throwable> " + errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
