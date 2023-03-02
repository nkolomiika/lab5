package commands;

import colors.ConsoleOutput;
import collections.DragonCollection;

import dragon.Dragon;
import exception.DragonCollectionIsEmptyException;
import exception.NoElementInCollectionException;
import superCommand.AbstractCommand;

/**
 * Class implements command remove_greater {element}.
 * Command remove elements that don`t exceed input element
 */
public class RemoveGreater extends AbstractCommand {

    public RemoveGreater(String commandName, DragonCollection dragonsCollection) {
        super(commandName, dragonsCollection);
        this.typeOfArg = null;
    }

    @Override
    public void execute() {

        try {

            if (dragonsCollection.getDragons().size() == 0)
                throw new DragonCollectionIsEmptyException();
            
            else {

                try {

                    Dragon inputDragon;

                    inputDragon = inputDragonData.inputDragon();
                    boolean flag = false;
                    int count = 0;

                    for (Dragon dragon : dragonsCollection.getDragons()) {
                        if (inputDragon.compareTo(dragon) < 0) {
                            dragonsCollection.getDragons().remove(dragon);
                            flag = true;
                            count ++;
                        }
                    }

                    if (!flag) throw new NoElementInCollectionException();

                    ConsoleOutput.messageOutput("Delete count of dragons : " + count);

                } catch (NoElementInCollectionException exception) {
                    ConsoleOutput.errOutput("No dragons which exceed this dragon");
                }

            }

        } catch (
                DragonCollectionIsEmptyException exception) {
            ConsoleOutput.errOutput("Dragon collection is empty");
        }

    }

    @Override
    public String getCommandInfo() {
        return " remove elements that exceed input element";
    }
}
