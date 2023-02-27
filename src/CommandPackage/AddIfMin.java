package CommandPackage;

import DragonCharacteristics.CustomComparator;
import DragonCharacteristics.Dragon;
import AbstractCommand.AbstractCommand;

import java.util.TreeSet;

/**
 * Class implements command add_if_min.
 * Command add element in collection, if input object lower than the min element
 */
public class AddIfMin extends AbstractCommand {

    public AddIfMin(String commandName, TreeSet<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {

        Add tmp = new Add("add", dragons);
        Dragon compareDragon = tmp.inputDragon();

        if (dragons.lower(compareDragon) == null) dragons.add(compareDragon);

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : add element in collection, if input object lower than the min element";
    }
}
