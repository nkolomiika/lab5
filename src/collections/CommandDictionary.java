package collections;

import superCommand.AbstractCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for keeping commands in Map(name, command)
 */
public class CommandDictionary {

    private Map<String, AbstractCommand> commands;

    public Map<String, AbstractCommand> getCommands() {
        return commands;
    }

    /**
     * Constructor, which create Map of commands(name, command) + add commands in array from constructor parameter
     *
     * @param commands
     */
    public CommandDictionary(AbstractCommand... commands) {
        this.commands = new HashMap<>();
        for (AbstractCommand command : commands) {
            this.commands.put(command.getCommandName(), command);
        }
    }

    /**
     * Check does command with this name exist + use method execute(), if exist
     *
     * @param commandName
     */
    public void executeCommand(String commandName) {
        if (commands.get(commandName) != null) commands.get(commandName).execute();
        else System.out.println("Input command is incorrect. Try it again :3");
    }

}
