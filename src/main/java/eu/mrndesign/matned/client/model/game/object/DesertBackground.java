package eu.mrndesign.matned.client.model.game.object;

public class DesertBackground extends GameElement {


    public DesertBackground() {
        super("Background", 0, null, null);
    }

    @Override
    public String getUrl() {
        return "img/desert-background.jpg";
    }

    @Override
    public void refresh() {

    }

    @Override
    public void mouseMove(int x, int y) {

    }

    @Override
    public void action(int x, int y) {

    }
}
