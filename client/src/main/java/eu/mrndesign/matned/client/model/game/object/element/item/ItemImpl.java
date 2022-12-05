package eu.mrndesign.matned.client.model.game.object.element.item;

import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.data.model.ActionData;
import eu.mrndesign.matned.client.model.game.object.data.model.ItemData;
import eu.mrndesign.matned.client.model.game.object.element.BaseElement;

import java.util.List;

public class ItemImpl extends BaseElement implements Item {

    private final ItemData itemData;

    public ItemImpl(Game game, ItemData itemData) {
        super(game, "Item", itemData);
        this.itemData = itemData;
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
