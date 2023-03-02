package untilities;

import collections.CommandDictionary;

/**
 * Class of console working
 */
public class ConsoleWorker {

    CommandRegister commandRegister;
    CommandDictionary commandDictionary;

    public ConsoleWorker(CommandDictionary commandDictionary, CommandRegister commandRegister) {
        this.commandDictionary = commandDictionary;
        this.commandRegister = commandRegister;
    }

    /**
     * Method check type of input command and execute it with or without arguments
     * @param inputStr
     */
    public void executeInputCommand(String inputStr) {

        String[] commandArr = commandRegister.getCommandFromInputConsoleCommand(inputStr);

        if (commandArr != null) {
            if (commandDictionary.getCommands().get(commandArr[0]).getTypeOfArg() != null) {
                commandDictionary.executeCommand(commandArr[0], commandArr[1]);
            }
            if (commandDictionary.getCommands().get(commandArr[0]).getTypeOfArg() == null) {
                commandDictionary.executeCommand(commandArr[0]);
            }
        }

    }

}
