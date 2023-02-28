package commandPackage;

import dragonCharacteristics.Dragon;
import collections.DragonCollection;

import java.util.*;

import exception.DragonCollectionIsEmptyException;
import superCommand.AbstractCommand;

/**
 * Class implements command filter_starts_with_description description.
 * Command output elements, which start with input string
 */
//add try+catch
public class FilterStartsWithDescription extends AbstractCommand {

    public FilterStartsWithDescription(String commandName, DragonCollection dragonsCollection) {
        super(commandName, dragonsCollection);
    }

    @Override
    public void execute() {

        try {

            String inputDescription = inputDragonData.inputDescription().trim();
            int count = 0;

            if (dragonsCollection.getDragons().size() == 0) throw new DragonCollectionIsEmptyException();
            for (Dragon dragon : dragonsCollection.getDragons()) {
                if (inputDescription.equals(dragon.getDescription().substring(0, dragon.getDescription().length()))) {
                    count++;
                    dragon.toString();
                }
            }

            if (count == 0)
                System.out.println("There are no one dragon`s description which starts with this string");

        } catch (DragonCollectionIsEmptyException exception) {
            System.out.println("Dragon collection is empty");
        }

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : output elements, which start with input string";
    }
}
