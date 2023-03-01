package commands;

import collections.DragonCollection;

import dragon.Dragon;
import exception.DragonCollectionIsEmptyException;
import superCommand.AbstractCommand;

/**
 * Class implements command add_if_max.
 * Command add element in collection, if input object higher than the max element
 */
public class AddIfMax extends AbstractCommand {

    public AddIfMax(String commandName, DragonCollection dragonsCollection) {
        super(commandName, dragonsCollection);
        this.typeOfArg = null;
    }

    @Override
    public void execute() {

        try {

            Dragon compareDragon = inputDragonData.inputDragon();

            if (dragonsCollection.getDragons().size() == 0) throw new DragonCollectionIsEmptyException();

            if (dragonsCollection.getDragons().last().compareTo(compareDragon) < 0) {
                dragonsCollection.getDragons().add(compareDragon);
                System.out.println("Dragon added to collection");
            } else {
                System.out.println("Dragon lower than the greatest dragon in collection ");
            }

        } catch (DragonCollectionIsEmptyException exception) {
            System.out.println("Dragon collection is empty");
        }

    }

    @Override
    public String getCommandInfo() {
        return " add element in collection, if input object higher than the max element";
    }
}
