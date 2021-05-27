package commands;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesus Larez
 */
public class UnknownCommand extends FrontCommand {

    private final static Logger LOGGER = Logger.getLogger("system_logger");

    @Override
    public void process() {
        HttpSession session = request.getSession(true);
        String message = (String) session.getAttribute("errorMessage");
        try {
            Handler fileHandler = new FileHandler("log.txt", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.addHandler(fileHandler);
            LOGGER.log(Level.INFO, "Log error : " + message);
            fileHandler.close();
        } catch (IOException | SecurityException ex) {
            Logger.getLogger("system_logger").log(Level.SEVERE, null, ex);
        }
        forward("/unknown.jsp");
    }
}