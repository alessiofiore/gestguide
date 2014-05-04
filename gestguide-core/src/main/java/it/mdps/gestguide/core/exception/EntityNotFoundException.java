package it.mdps.gestguide.core.exception;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private ErrorType errorType;
	
	public EntityNotFoundException() {
		this.errorType = ErrorType.GENERIC_EXCEPTION;
	}
	
	public EntityNotFoundException(ErrorType errorType) {
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
		LICENCE_NOT_FOUND,
		SCHOOL_NOT_FOUND,
		SUBSCRIPTION_NOT_FOUND,
		VEHICLE_NOT_FOUND;
	}
}
