package eu.mrndesign.matned.client.view.screencontent.menu;

import com.google.gwt.user.client.ui.Button;
import eu.mrndesign.matned.client.view.ScreenManager;
import eu.mrndesign.matned.client.view.ScreenManagerInterface;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import java.util.logging.Logger;

public class MenuButton extends Button {

    private final ScreenManager.ScreenType screenType;
    private final Subject<Boolean> selectSubject = PublishSubject.create();

    public MenuButton(ScreenManagerInterface screenManager, ScreenManager.ScreenType screenType) {
        this.screenType = screenType;
        setText(screenType.getName());
            getElement().setClassName("button not-selected");
        selectSubject.map(selected -> {
            getElement().setClassName(selected?"button selected":"button not-selected");
            return selected;
        }).subscribe();
        setWidth("100%");
        selectSubject.onNext(false);
        addClickHandler(event -> {
            selectSubject.onNext(true);
            screenManager.onMenuButtonClick(this.screenType);
        });
    }

    public void setSelected(boolean status){
        selectSubject.onNext(status);
    }

    public ScreenManager.ScreenType getScreenType() {
        return screenType;
    }
}
