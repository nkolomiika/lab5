package commands;

import collections.DragonCollection;
import dragon.Dragon;

import exception.DragonCollectionIsEmptyException;
import exception.NoElementInCollectionException;
import superCommand.AbstractCommand;

/**
 * Class implements command remove_by_id.
 * Command remove element by input id
 */
//add try+catch
public class RemoveById extends AbstractCommand {

    public RemoveById(String commandName, DragonCollection dragonsCollection) {
        super(commandName, dragonsCollection);
    }

    @Override
    public void execute() {

        try {

            if (dragonsCollection.getDragons().size() == 0)
                throw new DragonCollectionIsEmptyException();
            else {

                try {

                    Long inputId;

                    while (true) {

                        inputId = inputDragonData.inputId();
                        boolean flag = false;

                        for (Dragon dragon : dragonsCollection.getDragons()) {
                            if (dragon.getId().equals(inputId)) {
                                dragonsCollection.getDragons().remove(dragon);
                                flag = true;
                                break;
                            }
                        }

                        if (!flag) throw new NoElementInCollectionException();

                        break;
                    }
                } catch (NoElementInCollectionException exception) {
                    System.out.println("No dragon with that id in collection");
                }

            }

        } catch (DragonCollectionIsEmptyException exception) {
            System.out.println("Dragon collection is empty");
        }

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : remove element by input id";
    }
}
