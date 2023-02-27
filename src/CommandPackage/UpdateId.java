package CommandPackage;

import AbstractCommand.AbstractCommand;
import DragonCharacteristics.Dragon;

import java.util.TreeSet;

/**
 * Class implements command update id {element}.
 * Command update element in collection with input id
 */
public class UpdateId extends AbstractCommand {

    public UpdateId(String commandName, TreeSet<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : update element in collection with input id";
    }

}
