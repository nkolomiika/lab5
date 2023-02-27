package CommandPackage;

import java.util.*;
import AbstractCommand.AbstractCommand;

/**
 * Class implements command help.
 * Command output information about unlocked command
 */
public class Help extends AbstractCommand {

    public Help(String commandName, Map<String, AbstractCommand> commands) {
        super(commandName, commands);
    }

    @Override
    public void execute() {
        for (var entry : commands.entrySet()) {
            System.out.println(entry.getValue().getCommandInfo());
        }
    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : output information about unlocked commands";
    }
}
