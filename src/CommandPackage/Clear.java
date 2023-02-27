package CommandPackage;

import DragonCharacteristics.Dragon;

import java.util.TreeSet;
import AbstractCommand.AbstractCommand;

/**
 * Class implements command clear.
 * Command clear the dragon collection
 */
public class Clear extends AbstractCommand {

    public Clear(String commandName, TreeSet<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {
        dragons.clear();
    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : clear the dragon`s collection";
    }
}
