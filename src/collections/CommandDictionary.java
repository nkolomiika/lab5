package collections;

import exception.IncorrectInputInScriptException;
import superCommand.AbstractCommand;
import superCommand.TypeOfArguments;
import untilities.file.Convector;

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
     * @param commands array of usable commands
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
     * @param commandName name of input command
     */
    public void executeCommand(String commandName) throws IncorrectInputInScriptException, IOException {
        commands.get(commandName).execute();
    }
    /**
     * Execute command with arguments, check their type
     * @param commandName, args
     */
    public void executeCommand(String commandName, String args) throws IncorrectInputInScriptException, IOException {
        //if (commands.get(commandName) != null)
        if (commands.get(commandName).getTypeOfArg().equals(TypeOfArguments.STRING)
            && convector.checkValidStringFromArg(args) != null) {
            commands.get(commandName).execute(convector.checkValidStringFromArg(args));
        }
        if (commands.get(commandName).getTypeOfArg().equals(TypeOfArguments.LONG)
            && convector.convertArgToLongType(args) != null) {
            commands.get(commandName).execute(convector.convertArgToLongType(args));
        }
        if (commands.get(commandName).getTypeOfArg() == null) {
            commands.get(commandName).execute();
        }
        //else System.out.println("Incorrect name of command");
    }

}
