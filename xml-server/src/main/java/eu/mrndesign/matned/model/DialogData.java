package eu.mrndesign.matned.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class DialogData implements Serializable {

    private String title = "";
    private final List<String> texts = new ArrayList<>();
    private final List<DialogData> options = new ArrayList<>();
    private boolean exitDialog;

    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

    @XmlElementWrapper(name = "texts")
    @XmlElement(name = "text")
    public List<String> getTexts() {
        return texts;
    }

    @XmlElementWrapper(name = "options")
    @XmlElement(name = "option")
    public List<DialogData> getOptions() {
        return options;
    }

    @XmlElement(name = "exit", defaultValue = "true")
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
