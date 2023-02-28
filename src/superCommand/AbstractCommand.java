package superCommand;

import collections.CommandDictionary;
import collections.DragonCollection;
import untilities.InputDragonData;

/**
 * Abstract class of commands
 */
public abstract class AbstractCommand implements Command {
    private String commandName;
    protected InputDragonData inputDragonData;
    protected DragonCollection dragonsCollection;
    protected CommandDictionary commandDictionary;

    public AbstractCommand(String commandName, DragonCollection dragons) {
        this.commandName = commandName;
        this.dragonsCollection = dragons;
    }

    public AbstractCommand(String commandName, CommandDictionary commandDictionary) {
        this.commandName = commandName;
        this.commandDictionary = commandDictionary;
    }

    public AbstractCommand(String commandName) {
        this.commandName = commandName;
    }

    /**
     * Method return command`s name
     *
     * @return String
     */
    public String getCommandName() {
        return commandName;
    }

    /**
     * Method return simple info about command
     *
     * @return String
     */
    public abstract String getCommandInfo();

}
