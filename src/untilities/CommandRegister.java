package untilities;

import collections.CommandDictionary;
import superCommand.AbstractCommand;

import java.util.Map;

/**
 * InputDragonDataFromArg parser, checking input string
 */
public class CommandRegister {

    private CommandDictionary commandDictionary;

    public CommandRegister(CommandDictionary commandDictionary) {
        this.commandDictionary = commandDictionary;
    }

    public String[] getCommandFromInputConsoleCommand(String inputString) {

        String[] res = new String[2];
        String str = inputString.trim();
        res[0] = str.contains(" ") ? str.substring(0, str.indexOf(" ")) : str;
        res[1] = str.contains(" ") ? str.substring(str.indexOf(" ") + 1, str.length()) : "";

        if (checkValidCommandFromConsole(res)) {
            return res;
        }
        return null;
    }

    public boolean checkValidCommandFromConsole(String[] command) {

        AbstractCommand tmp;

        if (commandDictionary.getCommands().get(command[0]) != null) {

            tmp = commandDictionary.getCommands().get(command[0]);

            if (command[0].equals("filter_starts_with_description")
                    || command[0].equals("filter_contains_name"))
                return true;

            else if (tmp.getTypeOfArg() != null
                    && command[1].split("\\s+").length == 1)
                return true;

            else if (tmp.getTypeOfArg() == null
                    && command[1].equals("")) {
                return true;

            } else {
                System.out.println("Invalid argument format");
                return false;
            }

        } else {
            System.out.println("Invalid command name");
            return false;
        }
    }
}
