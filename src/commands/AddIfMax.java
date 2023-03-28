package commands;

import colors.ConsoleOutput;
import collections.DragonCollection;

import dragon.Dragon;
import exception.DragonCollectionIsEmptyException;
import exception.IncorrectInputInScriptException;
import superCommand.AbstractCommand;
import untilities.InputData;

/**
 * Class implements command add_if_max.
 * Command add element in collection, if input object higher than the max element
 */
public class AddIfMax extends AbstractCommand {

    public AddIfMax(String commandName, DragonCollection dragonsCollection, InputData inputData) {
        super(commandName, dragonsCollection, inputData);
        this.typeOfArg = null;
    }

    @Override
    public void execute() throws IncorrectInputInScriptException {

        try {

            if (dragonsCollection.getDragons().size() == 0) throw new DragonCollectionIsEmptyException();

            Dragon compareDragon = inputDragonData.inputDragon();


            if (dragonsCollection.getDragons().last().compareTo(compareDragon) < 0) {
                dragonsCollection.getDragons().add(compareDragon);
                ConsoleOutput.messageOutput("Dragon added to collection");
            } else {
                System.out.println("Dragon lower than the greatest dragon in collection ");
            }

        } catch (DragonCollectionIsEmptyException exception) {
            ConsoleOutput.errOutput("Dragon collection is empty");
        }

    }

    @Override
    public String getCommandInfo() {
        return " add element in collection, if input object higher than the max element";
    }
}
