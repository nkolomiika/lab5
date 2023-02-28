package commandPackage;

import collections.CustomComparator;
import collections.DragonCollection;

import dragonCharacteristics.Dragon;
import exception.DragonCollectionIsEmptyException;
import exception.NoElementInCollectionException;
import superCommand.AbstractCommand;

/**
 * Class implements command remove_greater {element}
 * Command remove elements that don`t exceed input element
 */
public class RemoveGreater extends AbstractCommand {

    public RemoveGreater(String commandName, DragonCollection dragonsCollection) {
        super(commandName, dragonsCollection);
    }

    @Override
    public void execute() {

        try {

            if (dragonsCollection.getDragons().size() == 0)
                throw new DragonCollectionIsEmptyException();
            else {

                try {

                    Dragon inputDragon;

                    while (true) {

                        inputDragon = inputDragonData.inputDragon();
                        boolean flag = false;

                        for (Dragon dragon : dragonsCollection.getDragons()) {
                            if (inputDragon.compareTo(dragon) < 0) {
                                dragonsCollection.getDragons().remove(dragon);
                                flag = true;
                                break;
                            }
                        }

                        if (!flag) throw new NoElementInCollectionException();

                        break;
                    }
                } catch (NoElementInCollectionException exception) {
                    System.out.println("No dragons which exceed this dragon");
                }

            }

        } catch (DragonCollectionIsEmptyException exception) {
            System.out.println("Dragon collection is empty");
        }

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : remove elements that exceed input element";
    }
}
