package eu.mrndesign.matned.client.model.tool.phisic;

import eu.mrndesign.matned.client.model.game.object.element.Element;

public interface Gravity {

    void calculate(Element character, double speed);

}
