package eu.mrndesign.matned.client.view.screenmanager;

import com.google.gwt.user.client.ui.*;
import eu.mrndesign.matned.client.view.screenmanager.menu.MenuButton;
import eu.mrndesign.matned.client.view.screenmanager.screencontent.Content;

import java.util.ArrayList;
import java.util.List;

public class Screen extends Composite implements ScreenInterface {

    protected ScreenManagerInterface screenManager;
    private final HorizontalPanel mainGrid;
    protected ScreenManager.ScreenType screenType;

    private VerticalPanel menuPanel;
    private final List<MenuButton> widgets = new ArrayList<>();

    private Content actualContent;

    public Screen(ScreenManagerInterface screenManager, ScreenManager.ScreenType screenType, Content content) {
        this.screenManager = screenManager;
        this.screenType = screenType;
        actualContent = content;
        mainGrid = new HorizontalPanel();
        mainGrid.getElement().setClassName("menu-bar left");
        menuPanel = new VerticalPanel();
        menuPanel.getElement().setClassName("menu-bar buttons-bar");
        ScreenManager.ScreenType.buttons().forEach(type -> {
            MenuButton menuButton = new MenuButton(screenManager, type);
            widgets.add(menuButton);
            menuPanel.add(menuButton);
        });
        mainGrid.add(menuPanel);
        mainGrid.add(content);
        initWidget(mainGrid);
    }

    @Override
    public void show() {
        RootPanel.get().add(this);
    }

    @Override
    public void hide() {
        RootPanel.get().remove(this);
    }

    @Override
    public void setContent(Content content) {
        mainGrid.remove(actualContent);
        actualContent = content;
        mainGrid.add(content);
        screenType = content.getScreenType();
        widgets.forEach(w -> w.setSelected(false));
        widgets.stream().filter(w -> w.getScreenType() == screenType).forEach(w -> w.setSelected(true));
    }

}
