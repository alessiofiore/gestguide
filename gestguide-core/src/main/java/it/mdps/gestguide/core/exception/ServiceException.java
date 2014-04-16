package it.mdps.gestguide.core.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private ErrorType errorType;
	
	public ServiceException() {
		this.errorType = ErrorType.GENERIC_EXCEPTION;
	}
	
	public ServiceException(ErrorType errorType) {
		this.errorType = errorType;
	}
	
	public ErrorType getErrorType() {
		return errorType;
	}
	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}

	public enum ErrorType {
		GENERIC_EXCEPTION,
		INSTRUCTOR_NOT_FOUND,
		LICENCE_NOT_FOUND;
	}
}
