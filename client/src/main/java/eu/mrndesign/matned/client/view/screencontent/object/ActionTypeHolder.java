package eu.mrndesign.matned.client.view.screencontent.object;

import eu.mrndesign.matned.client.model.game.object.ActionType;

import java.util.HashMap;
import java.util.Map;

public class ActionTypeHolder {

    private volatile static ActionTypeHolder instance;

    public static ActionTypeHolder getInstance() {
        if (instance == null){
            synchronized (ActionTypeHolder.class){
                if (instance == null) {
                    instance = new ActionTypeHolder();
                }
            }
        }
        return instance;
    }

    private final Map<String, ActionType> mapElementIdsToActualActionsActions = new HashMap<>();

    private ActionTypeHolder() {
    }

    public void put(String id, ActionType actionType) {
        mapElementIdsToActualActionsActions.put(id, actionType);
    }

    public ActionType get(String id) {
        return mapElementIdsToActualActionsActions.get(id);
    }

}
