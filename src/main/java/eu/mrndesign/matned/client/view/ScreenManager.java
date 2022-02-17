package eu.mrndesign.matned.client.view;

import eu.mrndesign.matned.client.controller.Controller;
import eu.mrndesign.matned.client.controller.ControllerImpl;
import eu.mrndesign.matned.client.view.screencontent.*;

import java.util.Arrays;
import java.util.List;

public class ScreenManager implements ScreenManagerInterface {

    private final ScreenInterface screen = new Screen(this, ScreenType.START_SCREEN, OptionsContent.getInstance());
    private Controller controller;

    @Override
    public void start() {
        initializeScreen(ScreenType.START_SCREEN);
        screen.show();
        controller = new ControllerImpl();
    }

    @Override
    public void initializeScreen(ScreenType screenType) {
        switch (screenType) {
            case ABOUT: {
                screen.setContent(AboutContent.getInstance());
                break;
            }
            case QUIT: {
                screen.setContent(QuitContent.getInstance());
                break;
            }
            case NEW_GAME: {
                screen.setContent(GameContent.getInstance(controller));
                break;
            }
            case OPTIONS: {
                screen.setContent(OptionsContent.getInstance());
                break;
            }
            default: {
                screen.setContent(StartContent.getInstance());
            }
        }
    }

    @Override
    public void onMenuButtonClick(ScreenType screenType) {
        initializeScreen(screenType);
    }


    public enum ScreenType {
        START_SCREEN,
        NEW_GAME,
        OPTIONS,
        ABOUT,
        QUIT;

        public static List<ScreenType> buttons(){
            return Arrays.asList(NEW_GAME, OPTIONS, ABOUT);
        }

        public String getName(){
            switch (this) {
                case NEW_GAME: return "New";
                case OPTIONS: return "Options";
                case ABOUT: return "About";
                case QUIT: return "Quit";
                default: return "Home page";
            }

        }
    }

}

