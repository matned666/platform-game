package eu.mrndesign.matned.client.model.tool.phisic;

import eu.mrndesign.matned.client.model.game.object.element.Element;

public interface Gravity {

    /**
     * @param character falling {@link Element}
     * @param speed     vertical jump speed
     * @param fly
     * @return <code>false</code> if character {@link Element} has landed
     */
    boolean calculate(Element character, double speed, boolean fly);

}
