package CommandPackage;

import DragonCharacteristics.Dragon;

import java.util.Iterator;
import java.util.TreeSet;

import AbstractCommand.AbstractCommand;

/**
 * Class implements command remove_greater {element}
 * Command remove elements that don`t exceed input element
 */
public class RemoveGreater extends AbstractCommand {

    public RemoveGreater(String commandName, TreeSet<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {
        Add tmp = new Add("add", dragons);
        Dragon compareDragon = tmp.inputDragon();

        if (dragons.higher(compareDragon) != null) {
            for (var dragon = dragons.tailSet(compareDragon).iterator(); dragon.hasNext(); ) {
                dragons.remove(dragon.next());
            }
        }

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : remove elements that don`t exceed input element";
    }
}
