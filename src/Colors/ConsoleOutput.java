package Colors;

import static Colors.OutputColors.*;

public class ConsoleOutput {

    /**
     * Method output red message, which means that command couldn`t execute
     * @param err
     */
    public static void errOutput(String err){
        System.out.println(ANSI_RED + err + ANSI_RESET);
    }

    /**
     * Method output green message, which means that command has already execute
     * @param message
     */
    public static void messageOutput(String message){
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

}
