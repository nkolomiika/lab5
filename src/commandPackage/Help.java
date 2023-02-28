package commandPackage;

import java.util.*;

import collections.CommandDictionary;
import superCommand.AbstractCommand;

/**
 * Class implements command help.
 * Command output information about unlocked command
 */
public class Help extends AbstractCommand {

    public Help(String commandName, CommandDictionary commandDictionary) {
        super(commandName, commandDictionary);
    }

    @Override
    public void execute() {

        for (var entry : commandDictionary.getCommands().entrySet()) {
            System.out.println(entry.getValue().getCommandInfo());
        }

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : output information about unlocked commands";
    }
}
