package eu.mrndesign.matned.client.model.game.object;

public class UnrecognizedActionTypeException extends RuntimeException{

    public UnrecognizedActionTypeException(String actionTypeName) {
        super("This action type is unrecognized: " + actionTypeName);
    }
}
