package eu.mrndesign.matned.client.view.screenmanager;

import eu.mrndesign.matned.client.view.screenmanager.screencontent.*;

import java.util.Arrays;
import java.util.List;

public class ScreenManager implements ScreenManagerInterface {

    private final ScreenInterface screen = new Screen(this, ScreenType.OPTIONS, new OptionsContent());;

    @Override
    public void start() {
        initializeScreen(ScreenType.START_SCREEN);
    }

    @Override
    public void initializeScreen(ScreenType screenType) {
        screen.hide();
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
                screen.setContent(new GameContent());
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
        screen.show();
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
            return Arrays.asList(NEW_GAME, OPTIONS, ABOUT, QUIT);
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

