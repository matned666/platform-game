package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

public class StarShip extends GameElement{


    public StarShip() {
        super("StarShip", 2, new Vector2D(0, 100), new Bounds2D(50, 80, new Point2D(500, 250)));
    }

    @Override
    public String getUrl() {
        return "img/starship.png";
    }

    @Override
    public void refresh(int x, int y) {
        rotate(x,y);
    }

    @Override
    public void action(int x, int y) {
        moveTo(x, y);
    }
}
