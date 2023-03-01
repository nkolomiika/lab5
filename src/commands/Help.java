package commands;

import collections.CommandDictionary;
import superCommand.AbstractCommand;

import static Colors.OutputColors.ANSI_PURPLE;
import static Colors.OutputColors.ANSI_RESET;

/**
 * Class implements command help.
 * Command output information about unlocked command
 */
public class Help extends AbstractCommand {

    public Help(String commandName, CommandDictionary commandDictionary) {
        super(commandName, commandDictionary);
        this.typeOfArg = null;
    }

    @Override
    public void execute() {

        for (var entry : commandDictionary.getCommands().entrySet()) {
            System.out.println(ANSI_PURPLE + entry.getKey() + ANSI_RESET + " :" + entry.getValue().getCommandInfo());
        }

    }

    @Override
    public String getCommandInfo() {
        return " output information about unlocked commands";
    }
}