package exceptions;

public class InitializerErrorException extends RuntimeException {

	
	
	public InitializerErrorException() {
		super();
	}
	
	public InitializerErrorException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InitializerErrorException(String message) {
		super(message);
	}
}
