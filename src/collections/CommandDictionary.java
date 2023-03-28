package collections;

import exception.IncorrectInputInScriptException;
import superCommand.AbstractCommand;
import untilities.Convector;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for keeping commands in Map(name, command)
 */
public class CommandDictionary {

    private Map<String, AbstractCommand> commands;
    private Convector convector;

    public Map<String, AbstractCommand> getCommands() {
        return commands;
    }

    /**
     * Constructor, which create Map of commands(name, command) + add commands in array from constructor parameter
     *
     * @param commands
     */
    public CommandDictionary(Convector convector, AbstractCommand... commands) {
        this.commands = new HashMap<>();
        for (AbstractCommand command : commands) {
            this.commands.put(command.getCommandName(), command);
        }
        this.convector = convector;
    }

    public void addCommand(AbstractCommand command){
        this.commands.put(command.getCommandName(), command);
    }

    /**
     * Execute command
     * @param commandName
     */
    public void executeCommand(String commandName) throws IncorrectInputInScriptException {
        commands.get(commandName).execute();
    }
    /**
     * Execute command with arguments
     * @param commandName, args
     */
    public void executeCommand(String commandName, String args) throws IncorrectInputInScriptException, IOException {
        //if (commands.get(commandName) != null)
        if (commands.get(commandName).getTypeOfArg().getTittle().equals("String")
            && convector.checkValidStringFromArg(args) != null) {
            commands.get(commandName).execute(convector.checkValidStringFromArg(args));
        }
        if (commands.get(commandName).getTypeOfArg().getTittle().equals("Long")
            && convector.convertArgToLongType(args) != null) {
            commands.get(commandName).execute(convector.convertArgToLongType(args));
        }
        if (commands.get(commandName).getTypeOfArg() == null) {
            commands.get(commandName).execute();
        }
        //else System.out.println("Incorrect name of command");
    }

}
