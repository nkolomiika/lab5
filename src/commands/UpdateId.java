package commands;

import colors.ConsoleOutput;
import collections.DragonCollection;
import dragon.Dragon;
import exception.NoElementInCollectionException;
import superCommand.AbstractCommand;
import superCommand.TypeOfArguments;

/**
 * Class implements command update id {element}.
 * Command update element in collection with input id
 */
public class UpdateId extends AbstractCommand {

    public UpdateId(String commandName, DragonCollection dragonsCollection) {
        super(commandName, dragonsCollection);
        this.typeOfArg = TypeOfArguments.LONG;
    }

    @Override
    public void execute(Long argId) {


        try {

            Long inputId;

            while (true) {

                //inputId = consoleInput.inputFromStringId();
                boolean flag = false;

                for (Dragon dragon : dragonsCollection.getDragons()) {
                    if (dragon.getId().equals(argId)) {
                        dragon.setId(argId);
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
            ConsoleOutput.errOutput("No dragon with that id in collection");
        }

    }

    @Override
    public String getCommandInfo() {
        return " update element in collection with input id";
    }

}
