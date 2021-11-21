package domain.common;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class LoggerService {

    private static final Logger LOGGER = Logger.getLogger(LoggerService.class.getName());

    public void log(String message) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, message);
        }
    }

    public void err(String message) {
        if (LOGGER.isLoggable(Level.SEVERE)) {
            LOGGER.log(Level.SEVERE, message);
        }
    }

}