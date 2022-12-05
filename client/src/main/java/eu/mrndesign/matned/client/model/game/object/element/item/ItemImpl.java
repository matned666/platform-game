package eu.mrndesign.matned.client.model.game.object.element.item;

import eu.mrndesign.matned.client.model.game.object.ActionType;
import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.data.model.ActionData;
import eu.mrndesign.matned.client.model.game.object.data.model.ItemData;
import eu.mrndesign.matned.client.model.game.object.element.BaseElement;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;

import java.util.List;

public class ItemImpl extends BaseElement implements Item {

    private final ItemData itemData;

    public ItemImpl(Game game, ItemData itemData) {
        super(game, "Item", itemData);
        this.itemData = itemData;
    }

    @Override
    public void refresh() {
//        TODO
    }

    @Override
    public void move(Vector2D v, double initSpeed, ActionType actionType) {
        super.move(v, initSpeed, actionType);
//        ToDO
    }

    @Override
    public List<ActionData> getActions() {
        return itemData.getActions();
    }

    @Override
    public ItemData getItemData() {
        return itemData;
    }
}
