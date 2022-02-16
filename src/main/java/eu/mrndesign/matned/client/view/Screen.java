package eu.mrndesign.matned.client.view;

import com.google.gwt.user.client.ui.*;
import eu.mrndesign.matned.client.view.screencontent.IContent;
import eu.mrndesign.matned.client.view.screencontent.menu.MenuButton;
import eu.mrndesign.matned.client.view.screencontent.Content;

import java.util.ArrayList;
import java.util.List;

public class Screen extends Composite implements ScreenInterface {

    protected ScreenManagerInterface screenManager;
    private final VerticalPanel mainGrid;
    protected ScreenManager.ScreenType screenType;

    private HorizontalPanel menuPanel;
    private final List<MenuButton> widgets = new ArrayList<>();

    private IContent actualContent;

    public Screen(ScreenManagerInterface screenManager, ScreenManager.ScreenType screenType, IContent content) {
        this.screenManager = screenManager;
        this.screenType = screenType;
        actualContent = content;
        mainGrid = new VerticalPanel();
        mainGrid.setHeight("100%");
        mainGrid.setWidth("100%");
        menuPanel = new HorizontalPanel();
        menuPanel.setWidth("100%");
        menuPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        menuPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        ScreenManager.ScreenType.buttons().forEach(type -> {
            MenuButton menuButton = new MenuButton(screenManager, type);
            widgets.add(menuButton);
            menuPanel.add(menuButton);
        });
        mainGrid.add(menuPanel);
        mainGrid.add(content.getWidget());
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
    public void setContent(IContent content) {
        mainGrid.remove(actualContent.getWidget());
        actualContent = content;
        mainGrid.add(content.getWidget());
        screenType = content.getScreenType();
        widgets.forEach(w -> w.setSelected(false));
        widgets.stream().filter(w -> w.getScreenType() == screenType).forEach(w -> w.setSelected(true));
    }

}
