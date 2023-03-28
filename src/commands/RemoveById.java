package commands;

import colors.ConsoleOutput;
import collections.DragonCollection;
import dragon.Dragon;

import dragon.DragonCharacter;
import exception.NoElementInCollectionException;
import superCommand.AbstractCommand;
import superCommand.TypeOfArguments;
import untilities.InputData;

/**
 * Class implements command remove_by_id.
 * Command remove element by input id
 */
//add try+catch
public class RemoveById extends AbstractCommand {

    public RemoveById(String commandName, DragonCollection dragonsCollection, InputData inputData) {
        super(commandName, dragonsCollection, inputData);
        this.typeOfArg = TypeOfArguments.LONG;
    }

    @Override
    public void execute(Long argId) {


        try {


            boolean flag = false;
            Dragon rmvDragon = null;

            for (Dragon dragon : dragonsCollection.getDragons()) {
                if (dragon.getId().equals(argId)) {
                    rmvDragon= dragon;
                    flag = true;
                }
            }
            if (!flag) throw new NoElementInCollectionException();
            dragonsCollection.getDragons().remove(rmvDragon);

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
