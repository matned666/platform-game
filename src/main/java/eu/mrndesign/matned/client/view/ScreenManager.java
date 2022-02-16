package eu.mrndesign.matned.client.view;

import eu.mrndesign.matned.client.controller.Controller;
import eu.mrndesign.matned.client.controller.ControllerImpl;
import eu.mrndesign.matned.client.view.screencontent.*;

import java.util.Arrays;
import java.util.List;

public class ScreenManager implements ScreenManagerInterface {

    private final ScreenInterface screen = new Screen(this, ScreenType.OPTIONS, new OptionsContent());;
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
                screen.setContent(new AboutContent());
                break;
            }
            case QUIT: {
                screen.setContent(new QuitContent());
                break;
            }
            case NEW_GAME: {
                screen.setContent(new GameContent(controller));
                break;
            }
            case OPTIONS: {
                screen.setContent(new OptionsContent());
                break;
            }
            default: {
                screen.setContent(new StartContent());
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

