package eu.mrndesign.matned.client.model.game.object.data.model;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DialogData {
    private static final Logger logger = Logger.getLogger(DialogData.class.getName());

//    TODO doesn't work - to repair
    public static DialogData parse(JSONObject dialog) {
        DialogData dialogData = new DialogData();
        dialogData.setExitDialog(dialog.get("exitDialog").isBoolean().booleanValue());
        dialogData.setTitle(dialog.get("title").isString().stringValue());
        JSONArray texts = dialog.get("texts").isArray();
        for (int i = 0; i < texts.size(); i++) {
            dialogData.getTexts().add(texts.get(i).isString().stringValue());
        }
        JSONArray options = dialog.get("options").isArray();
        for (int i = 0; i < options.size(); i++) {
            dialogData.getOptions().add(DialogData.parse(options.get(i).isObject()));
        }
        return dialogData;
    }

    private String title = "";
    private final List<String> texts = new ArrayList<>();
    private final List<DialogData> options = new ArrayList<>();
    private boolean exitDialog;

    public String getTitle() {
        return title;
    }

    public List<String> getTexts() {
        return texts;
    }

    public List<DialogData> getOptions() {
        return options;
    }

    public boolean isExitDialog() {
        return exitDialog;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setExitDialog(boolean exitDialog) {
        this.exitDialog = exitDialog;
    }

    @Override
    public String toString() {
        return "DialogData{" +
                "title='" + title + '\'' +
                ", texts=" + texts +
                ", options=" + options +
                ", exitDialog=" + exitDialog +
                '}';
    }
}
