package springboot.scratch.restapi;

public abstract class ControllerException extends RuntimeException {

    public ControllerException(String message) {
        super(message);
    }

}
