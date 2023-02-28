package commandPackage;

import collections.DragonCollection;

import dragonCharacteristics.Dragon;
import exception.DragonCollectionIsEmptyException;
import superCommand.AbstractCommand;

/**
 * Class implements command add_if_max.
 * Command add element in collection, if input object higher than the max element
 */
public class AddIfMax extends AbstractCommand {

    public AddIfMax(String commandName, DragonCollection dragonsCollection) {
        super(commandName, dragonsCollection);
    }

    @Override
    public void execute() {

        try {

            Dragon compareDragon = inputDragonData.inputDragon();

            if (dragonsCollection.getDragons().size() == 0) throw new DragonCollectionIsEmptyException();

            if (dragonsCollection.getDragons().higher(compareDragon) == null)
                dragonsCollection.getDragons().add(compareDragon);

        } catch (DragonCollectionIsEmptyException exception) {
            System.out.println("Dragon collection is empty");
        }

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : add element in collection, if input object higher than the max element";
    }
}
