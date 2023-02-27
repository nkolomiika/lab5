package CommandPackage;

import DragonCharacteristics.Dragon;

import java.util.TreeSet;
import AbstractCommand.AbstractCommand;

/**
 * Class implements command add_if_max.
 * Command add element in collection, if input object higher than the max element
 */
public class AddIfMax extends AbstractCommand {

    public AddIfMax(String commandName, TreeSet<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {

        Add tmp = new Add("add", dragons);
        Dragon compareDragon = tmp.inputDragon();

        if (dragons.higher(compareDragon) == null) dragons.add(compareDragon);

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : add element in collection, if input object higher than the max element";
    }
}
