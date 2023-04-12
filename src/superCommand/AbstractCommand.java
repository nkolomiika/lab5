package superCommand;

import collections.CommandDictionary;
import collections.DragonCollection;
import untilities.InputData;

/**
 * Abstract class of commands
 */
public abstract class AbstractCommand implements Command {

    protected boolean closed;
    protected TypeOfArguments typeOfArg;
    private String commandName;
    protected InputData inputDragonData;
    protected DragonCollection dragonsCollection;
    protected CommandDictionary commandDictionary;

    public AbstractCommand(String commandName, DragonCollection dragons, InputData inputData) {
        this.commandName = commandName;
        this.dragonsCollection = dragons;
        this.inputDragonData = inputData;
        closed = false;
    }

    public AbstractCommand(String commandName, CommandDictionary commandDictionary) {
        this.commandName = commandName;
        this.commandDictionary = commandDictionary;
    }

    public AbstractCommand(String commandName) {
        this.commandName = commandName;
    }

    public TypeOfArguments getTypeOfArg() {
        return typeOfArg;
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

    /**
     * If this method was called, application closed
     * @return flag to close application
     */
    public boolean isClosed() {
        return closed;
    }
}
