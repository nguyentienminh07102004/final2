package ExceptionHandler;

public class DuplicateMedicalRecordException extends RuntimeException{
	public DuplicateMedicalRecordException(String message) {
		super(message);
	}

	public DuplicateMedicalRecordException() {

	}
}
