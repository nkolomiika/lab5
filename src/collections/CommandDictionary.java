package collections;

import superCommand.AbstractCommand;
import untilities.Convector;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for keeping commands in Map(name, command)
 */
public class CommandDictionary {

    private Map<String, AbstractCommand> commands;
    Convector inputDragonDataFromArg;

    public Map<String, AbstractCommand> getCommands() {
        return commands;
    }

    /**
     * Constructor, which create Map of commands(name, command) + add commands in array from constructor parameter
     *
     * @param commands
     */
    public CommandDictionary(Convector inputDragonDataFromArg, AbstractCommand... commands) {
        this.commands = new HashMap<>();
        for (AbstractCommand command : commands) {
            this.commands.put(command.getCommandName(), command);
        }
        this.inputDragonDataFromArg = inputDragonDataFromArg;
    }

    public void addCommand(AbstractCommand command){
        this.commands.put(command.getCommandName(), command);
    }

    /**
     * Execute command
     * @param commandName
     */
    public void executeCommand(String commandName) {
        commands.get(commandName).execute();
    }
    /**
     * Execute command with arguments
     * @param commandName, args
     */
    public void executeCommand(String commandName, String args) {
        //if (commands.get(commandName) != null)
        if (commands.get(commandName).getTypeOfArg().getTittle().equals("String")
            && inputDragonDataFromArg.checkValidStringFromArg(args) != null) {
            commands.get(commandName).execute(inputDragonDataFromArg.checkValidStringFromArg(args));
        }
        if (commands.get(commandName).getTypeOfArg().getTittle().equals("Long")
            && inputDragonDataFromArg.convertArgToLongType(args) != null) {
            commands.get(commandName).execute(inputDragonDataFromArg.convertArgToLongType(args));
        }
        if (commands.get(commandName).getTypeOfArg() == null) {
            commands.get(commandName).execute();
        }
        //else System.out.println("Incorrect name of command");
    }

}
