import DragonCharacteristics.Dragon;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

interface Command {
    void execute();
}

abstract class AbstractCommand implements Command{
    private String commandName;
    protected Set<Dragon> dragons;
    protected Map<String, AbstractCommand> commands;

    public AbstractCommand(String commandName, Set<Dragon> dragons){
        this.commandName = commandName;
        this.dragons = new TreeSet<>();
    }

    public AbstractCommand(String commandName, Map<String, AbstractCommand> commands){
        this.commandName = commandName;
        this.commands = new HashMap<>();
    }

    public String getCommandName() {
        return commandName;
    }

    public AbstractCommand(String commandName){
        this.commandName = commandName;
    }

    abstract String getInfoCommandInfo();

}