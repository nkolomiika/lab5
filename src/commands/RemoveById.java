package commands;

import collections.DragonCollection;
import dragon.Dragon;

import exception.DragonCollectionIsEmptyException;
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

            if (dragonsCollection.getDragons().size() == 0)
                throw new DragonCollectionIsEmptyException();
            else {

                try {

                    while (true) {

                        boolean flag = false;

                        for (Dragon dragon : dragonsCollection.getDragons()) {
                            if (dragon.getId().equals(argId)) {
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
        return " remove element by input id";
    }
}
