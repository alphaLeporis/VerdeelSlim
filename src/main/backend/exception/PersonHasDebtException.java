package backend.exception;

public class PersonHasDebtException extends Exception {
    public PersonHasDebtException(String errorMessage) {
        super(errorMessage);
    }
}
