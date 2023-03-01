package untilities;

import collections.CommandDictionary;

public class ConsoleWorker {

    CommandRegister commandRegister;
    CommandDictionary commandDictionary;

    public ConsoleWorker(CommandDictionary commandDictionary, CommandRegister commandRegister) {
        this.commandDictionary = commandDictionary;
        this.commandRegister = commandRegister;
    }

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
