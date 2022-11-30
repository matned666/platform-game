package eu.mrndesign.matned.client.model.game.object.element.item;

import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.element.BaseElement;
import eu.mrndesign.matned.client.model.game.object.data.model.ItemData;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;

public class ItemImpl extends BaseElement implements Item{

    private final ItemData itemData;
    private boolean equipped;

    public ItemImpl(Game game, ItemData itemData) {
        super(game, "Item");
        this.itemData = itemData;
        bounds = Bounds2D.generate(itemData);
        equipped = itemData.isEquipped();
    }

    @Override
    public void refresh() {
//        TODO
    }

    @Override
    public void move(Vector2D v, double initSpeed) {
//        TODO
    }

    @Override
    public boolean isEquipped() {
        return equipped;
    }

    @Override
    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    @Override
    public ItemData getItemData() {
        return itemData;
    }
}
