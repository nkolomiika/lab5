package commands;

import collections.DragonCollection;
import dragon.Dragon;
import exception.DragonCollectionIsEmptyException;
import exception.NoElementInCollectionException;
import superCommand.AbstractCommand;

/**
 * Class implements command update id {element}.
 * Command update element in collection with input id
 */
public class UpdateId extends AbstractCommand {

    public UpdateId(String commandName, DragonCollection dragonsCollection) {
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
                                dragon.setId(inputId);
                                dragon.setName(inputDragonData.inputName());
                                dragon.setCoordinates(inputDragonData.inputCoordinates());
                                dragon.setAge(inputDragonData.inputAge());
                                dragon.setDescription(inputDragonData.inputDescription());
                                dragon.setSpeaking(inputDragonData.canSpeak());
                                dragon.setCharacter(inputDragonData.inputCharacter());
                                dragon.setHead(inputDragonData.inputDragonHead());
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
        return this.getCommandName() + " : update element in collection with input id";
    }

}
