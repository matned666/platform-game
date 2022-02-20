package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_INT;
import static eu.mrndesign.matned.client.controller.Constants.PANEL_WIDTH_INT;

public class StarShip extends GameElement{


    public StarShip() {
        super("StarShip", 5, new Vector2D(0, 100), new Bounds2D(50, 80, new Point2D(PANEL_WIDTH_INT/2, PANEL_HEIGHT_INT/2)));
    }

    @Override
    public String getUrl() {
        return "img/starship.png";
    }

    @Override
    public void refresh() {

    }

    @Override
    public void mouseMove(int x, int y) {
        rotate(x,y);
    }

    @Override
    public void action(int x, int y) {
        moveTo(x, y);
    }
}
