package untilities;

import colors.ConsoleOutput;
import collections.CommandDictionary;
import collections.DragonCollection;
import exception.DragonCollectionIsEmptyException;
import superCommand.AbstractCommand;

/**
 * InputDragonDataFromArg parser, checking input string
 */
public class CommandRegister {

    private CommandDictionary commandDictionary;
    private DragonCollection dragonCollection;

    public CommandRegister(CommandDictionary commandDictionary, DragonCollection dragonCollection) {
        this.commandDictionary = commandDictionary;
        this.dragonCollection = dragonCollection;
    }

    /**
     * Method get an input string and divide it on two elements(command+argument)
     * @param inputString
     * @return String[2]
     */
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

    /**
     * Method return true if command exist in dictionary of commands,
     * then check type of command (if command don`t exist method return false and print error)
     * @param command
     * @return boolean
     */
    public boolean checkValidCommandFromConsole(String[] command) {

        AbstractCommand tmp;

        if (commandDictionary.getCommands().get(command[0]) != null) {

            //boolean isEmpty = checkDragonsCollection();
            tmp = commandDictionary.getCommands().get(command[0]);

            if (command[0].equals("filter_starts_with_description")
                    || command[0].equals("filter_contains_name")) {

                if (checkDragonsCollection())
                    return true;

            } else if (tmp.getTypeOfArg() != null
                    && command[1].split("\\s+").length == 1) {

                if (checkDragonsCollection())
                    return true;

            } else if (tmp.getTypeOfArg() == null
                    && command[1].equals("")) {
                return true;

            } else {

                ConsoleOutput.errOutput("Invalid argument format");

                return false;
            }

            return false;

        } else {
            ConsoleOutput.errOutput("Invalid command name");
            return false;
        }
    }

    /**
     * Check dragons collection is empty or not
     * @return boolean
     */
    public boolean checkDragonsCollection() {

        try {
            if (dragonCollection.getDragons().size() == 0) {
                throw new DragonCollectionIsEmptyException();
            }
        } catch (DragonCollectionIsEmptyException exception) {
            ConsoleOutput.errOutput("Dragon collection is empty");
            return false;
        }

        return true;
    }

}
