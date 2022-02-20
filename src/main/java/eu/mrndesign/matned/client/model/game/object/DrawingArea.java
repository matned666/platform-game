package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Point2D;

import java.util.Map;
import java.util.TreeMap;

public class DrawingArea extends Bounds2D {

    protected final String id = "DrawingArea-" + System.currentTimeMillis();

    private final Map<String, GameElement> mapIdToGameElement = new TreeMap<>();
    private final GameElement background = new DesertBackground();

    public DrawingArea(double width, double height) {
        super(width, height, new Point2D(0,0));
        GameElement hero = GameElementsFactory.hero();
        mapIdToGameElement.put(hero.getId(), hero);
    }

    public void add(GameElement gameElement) {
        mapIdToGameElement.put(gameElement.getId(), gameElement);
    }

    public void remove(String id) {
        mapIdToGameElement.remove(id);
    }

    public Map<String, GameElement> getMapIdToGameElement() {
        return mapIdToGameElement;
    }

    public String getId() {
        return id;
    }

    public void mouseDownEvent(int x, int y) {
        mapIdToGameElement.values().forEach(gameElement -> gameElement.action(x,y));
    }

    public void mouseMoveEvent(int x, int y) {
        mapIdToGameElement.values().forEach(gameElement -> gameElement.refresh(x,y));
    }

    public String getBackgroundImage() {
        return background.getUrl();
    }



}
