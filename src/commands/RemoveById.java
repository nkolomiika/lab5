package commands;

import colors.ConsoleOutput;
import collections.DragonCollection;
import dragon.Dragon;

import exception.NoElementInCollectionException;
import superCommand.AbstractCommand;
import superCommand.TypeOfArguments;

/**
 * Class implements command remove_by_id.
 * Command remove element by input id
 */
//add try+catch
public class RemoveById extends AbstractCommand {

    public RemoveById(String commandName, DragonCollection dragonsCollection) {
        super(commandName, dragonsCollection);
        this.typeOfArg = TypeOfArguments.LONG;
    }

    @Override
    public void execute(Long argId) {


        try {


            boolean flag = false;

            for (Dragon dragon : dragonsCollection.getDragons()) {
                if (dragon.getId().equals(argId)) {
                    dragonsCollection.getDragons().remove(dragon);
                    flag = true;
                }
            }

            if (!flag) throw new NoElementInCollectionException();

            ConsoleOutput.messageOutput("Dragon with id = " + argId + " deleted");

        } catch (
                NoElementInCollectionException exception) {
            ConsoleOutput.errOutput("No dragon with that id in collection");
        }

    }

    @Override
    public String getCommandInfo() {
        return " remove element by input id";
    }
}
