package eu.mrndesign.matned.client.model.game.object.data.model;

import eu.mrndesign.matned.client.model.game.object.ActionType;

public interface BoundsData {

    double getWidth();

    double getHeight();

    double getDirectionX();

    double getDirectionY();

    double getStartXPos();

    double getStartYPos();

    ActionData getAction(ActionType actionType, boolean shiftDown, boolean ctrlDown);
}
