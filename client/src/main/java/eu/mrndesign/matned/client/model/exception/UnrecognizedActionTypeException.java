package eu.mrndesign.matned.client.model.exception;

public class UnrecognizedActionTypeException extends RuntimeException{

    public UnrecognizedActionTypeException(String actionTypeName) {
        super("This action type is unrecognized: " + actionTypeName);
    }
}
