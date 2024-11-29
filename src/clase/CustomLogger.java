package clase;
import java.io.IOException;
import java.util.logging.*;

public class CustomLogger {

    private static final Logger logger = Logger.getLogger(CustomLogger.class.getName());

    public CustomLogger() throws IOException {
        // Crear un Handler de consola
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL); // Aceptar todos los niveles de log
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);

        // Crear un Handler de fichero para los logs de ERROR y WARNING
        FileHandler fileHandler = new FileHandler("log.txt", true); // "true" para append
        fileHandler.setLevel(Level.WARNING); // Solo WARNING y ERROR
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);

        // Desactiva el uso de handlers del logger padre
        logger.setUseParentHandlers(false);
    }

    public static void logMessages() {
        logger.severe("Error: Este es un mensaje de error.");
        logger.warning("Warning: Este es un mensaje de advertencia.");
        logger.info("Info: Este es un mensaje informativo.");
        logger.fine("Debug: Este es un mensaje de depuración.");
    }

    public static void main(String[] args) throws IOException {
        // Crear una instancia del logger para ejecutar la configuración
        CustomLogger customLogger = new CustomLogger();

        // Registrar algunos mensajes de log
        logMessages();
    }
}
