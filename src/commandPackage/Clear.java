package commandPackage;

import collections.DragonCollection;

import dragonCharacteristics.Dragon;
import exception.DragonCollectionIsEmptyException;
import superCommand.AbstractCommand;

/**
 * Class implements command clear.
 * Command clear the dragon collection
 */
public class Clear extends AbstractCommand {

    public Clear(String commandName, DragonCollection dragonsCollection) {
        super(commandName, dragonsCollection);
    }

    @Override
    public void execute() {

        try {

            if (dragonsCollection.getDragons().size() == 0) throw new DragonCollectionIsEmptyException();

            dragonsCollection.getDragons().clear();

        } catch (DragonCollectionIsEmptyException exception) {
            System.out.println("Dragon collection is already clear");
        }

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : clear the dragon`s collection";
    }
}
