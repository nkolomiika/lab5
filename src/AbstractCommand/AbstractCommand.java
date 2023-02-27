package AbstractCommand;

import DragonCharacteristics.Dragon;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Abstract class of commands
 */
public abstract class AbstractCommand implements Command {
    private String commandName;
    protected TreeSet<Dragon> dragons;
    protected Map<String, AbstractCommand> commands;

    public AbstractCommand(String commandName, TreeSet<Dragon> dragons) {
        this.commandName = commandName;
        this.dragons = new TreeSet<>();
    }

    public AbstractCommand(String commandName, Map<String, AbstractCommand> commands) {
        this.commandName = commandName;
        this.commands = new HashMap<>();
    }

    public AbstractCommand(String commandName) {
        this.commandName = commandName;
    }

     /**
     * Method return command`s name
     * @return String
     */
    public String getCommandName() {
        return commandName;
    }

    /**
     * Method return simple info about command
     * @return String
     */
    public abstract String getCommandInfo();

}
