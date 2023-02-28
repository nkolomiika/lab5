package commandPackage;

import dragonCharacteristics.Dragon;
import collections.DragonCollection;

import exception.DragonCollectionIsEmptyException;
import superCommand.AbstractCommand;

/**
 * Class implements command show.
 * Command output in standard output all elements of collection in string representation
 */
public class Show extends AbstractCommand {

    public Show(String commandName, DragonCollection dragonsCollection) {
        super(commandName, dragonsCollection);
    }

    @Override
    public void execute() {

        try {

            if (dragonsCollection.getDragons().size() == 0) throw new DragonCollectionIsEmptyException();

            for (Dragon dragon : this.dragonsCollection.getDragons()) {
                System.out.println(dragon.toString());
            }

        } catch (DragonCollectionIsEmptyException exception) {
            System.out.println("Dragon collection is empty");
        }

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : output in standard output all elements of collection in string representation";
    }
}
