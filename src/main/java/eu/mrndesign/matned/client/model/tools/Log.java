package eu.mrndesign.matned.client.model.tools;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

    private static final Logger logger = Logger.getLogger("Logger");

    public static void log(String message) {
        logger.log(Level.SEVERE, message);
    }


}
