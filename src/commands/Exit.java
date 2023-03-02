package commands;

import Colors.ConsoleOutput;
import superCommand.AbstractCommand;

/**
 * Class implements command exit.
 * Command close console application(without save the file)
 */
public class Exit extends AbstractCommand {

    public Exit(String commandName) {
        super(commandName);
        this.typeOfArg = null;
    }

    @Override
    public void execute() {
        ConsoleOutput.messageOutput("Console application closed");
        System.exit(0);
    }

    @Override
    public String getCommandInfo() {
        return " close console application(without save the file)";
    }
}
