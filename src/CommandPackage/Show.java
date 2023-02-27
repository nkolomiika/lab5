package CommandPackage;

import DragonCharacteristics.Dragon;

import java.util.TreeSet;
import AbstractCommand.AbstractCommand;

/**
 * Class implements command show.
 * Command output in standard output all elements of collection in string representation
 */
public class Show extends AbstractCommand {

    public Show(String commandName, TreeSet<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {
        for (Dragon dragon : this.dragons) {
            System.out.println(dragon.toString());
        }
    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : output in standard output all elements of collection in string representation";
    }
}
