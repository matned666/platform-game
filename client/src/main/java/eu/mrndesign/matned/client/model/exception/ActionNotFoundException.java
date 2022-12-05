package eu.mrndesign.matned.client.model.exception;

import eu.mrndesign.matned.client.model.game.object.ActionType;

public class ActionNotFoundException extends RuntimeException{

    public ActionNotFoundException(String element, ActionType actionType) {
        super("Action for element: "+element+" not found: " +actionType.name());
    }
}
