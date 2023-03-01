package commands;

import superCommand.AbstractCommand;

/**
 * Class implements command exit.
 * Command close console application(without save the file)
 */
public class Exit extends AbstractCommand {

    public Exit(String commandName) {
        super(commandName);
    }

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : close console application(without save the file)";
    }
}
