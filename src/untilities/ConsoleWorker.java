package untilities;

import collections.CommandDictionary;
import exception.IncorrectInputInScriptException;

import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Class of console working
 */
public class ConsoleWorker {

    private CommandRegister commandRegister;
    private CommandDictionary commandDictionary;

    public ConsoleWorker(CommandRegister commandRegister, CommandDictionary commandDictionary) {
        this.commandRegister = commandRegister;
        this.commandDictionary = commandDictionary;
    }

    /**
     * Method check type of input command and execute it with or without arguments
     *
     * @param inputStr Input console command
     */
    public void executeInputCommand(String inputStr) throws IncorrectInputInScriptException, IOException {

        String[] commandArr = commandRegister.getCommandFromInputCommand(inputStr);

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
