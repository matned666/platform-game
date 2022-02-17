package eu.mrndesign.matned.client.view.screencontent.drawer;

import com.google.gwt.user.client.ui.Image;
import eu.mrndesign.matned.client.model.game.object.GameElement;

public class GameObj extends Image {

    private GameElement gameElement;

    public GameObj(GameElement gameElement) {
        super("img/starship.png");
        this.gameElement = gameElement;


    }


}
