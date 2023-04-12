package commands;

import colors.ConsoleOutput;
import collections.DragonCollection;

import exception.DragonCollectionIsEmptyException;
import superCommand.AbstractCommand;
import superCommand.TypeOfArguments;
import untilities.InputData;

/**
 * Class implements command clear.
 * Command clear the dragon collection
 */
public class Clear extends AbstractCommand {

    public Clear(String commandName, DragonCollection dragonsCollection, InputData inputData) {
        super(commandName, dragonsCollection, inputData);
        this.typeOfArg = TypeOfArguments.NULL;
    }

    @Override
    public void execute() {

        try {

            if (dragonsCollection.getDragons().size() == 0) throw new DragonCollectionIsEmptyException();

            dragonsCollection.getDragons().clear();
            ConsoleOutput.messageOutput("Dragon collection cleared");

        } catch (DragonCollectionIsEmptyException exception) {
            System.out.println("Dragon collection is already clear");
        }

    }

    @Override
    public String getCommandInfo() {
        return " clear the dragon`s collection";
    }
}
