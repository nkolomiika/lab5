package commands;

import colors.ConsoleOutput;
import dragon.Dragon;
import collections.DragonCollection;

import exception.DragonCollectionIsEmptyException;
import superCommand.AbstractCommand;
import superCommand.TypeOfArguments;
import untilities.InputData;

/**
 * Class implements command show.
 * Command output in standard output all elements of collection in string representation
 */
public class Show extends AbstractCommand {

    public Show(String commandName, DragonCollection dragonsCollection, InputData inputData) {
        super(commandName, dragonsCollection, inputData);
        this.typeOfArg = TypeOfArguments.NULL;
    }

    @Override
    public void execute() {

        try {

            if (dragonsCollection.getDragons().size() == 0) throw new DragonCollectionIsEmptyException();

            for (Dragon dragon : this.dragonsCollection.getDragons()) {
                System.out.println(dragon.toString());
            }

        } catch (DragonCollectionIsEmptyException exception) {
            ConsoleOutput.errOutput("Dragon collection is empty");
        }

    }

    @Override
    public String getCommandInfo() {
        return " output in standard output all elements of collection in string representation";
    }
}
