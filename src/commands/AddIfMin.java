package commands;

import collections.DragonCollection;
import dragon.Dragon;
import exception.DragonCollectionIsEmptyException;
import superCommand.AbstractCommand;

/**
 * Class implements command add_if_min.
 * Command add element in collection, if input object lower than the min element
 */
public class AddIfMin extends AbstractCommand {

    public AddIfMin(String commandName, DragonCollection dragonsCollection) {
        super(commandName, dragonsCollection);
        this.typeOfArg = null;
    }

    @Override
    public void execute() {

        try {

            Dragon compareDragon = inputDragonData.inputDragon();

            if (dragonsCollection.getDragons().size() == 0) throw new DragonCollectionIsEmptyException();

            if (dragonsCollection.getDragons().first().compareTo(compareDragon) > 0) {
                dragonsCollection.getDragons().add(compareDragon);
                System.out.println("Dragon added to collection");
            } else {
                System.out.println("Dragon higher than the lowest dragon in collection ");
            }

        } catch (DragonCollectionIsEmptyException exception) {
            System.out.println("Dragon collection is empty");
        }

    }

    @Override
    public String getCommandInfo() {
        return " add element in collection, if input object lower than the min element";
    }
}
