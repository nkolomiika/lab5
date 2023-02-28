package commandPackage;

import collections.DragonCollection;
import dragonCharacteristics.Dragon;


import superCommand.AbstractCommand;

import static java.lang.Long.parseLong;


//add try+catch

/**
 * Class implements command add.
 * This command add new element to collection
 */
public class Add extends AbstractCommand {

    public Add(String commandName, DragonCollection dragonsCollection) {
        super(commandName, dragonsCollection);
    }

    @Override
    public void execute() {

        Dragon dragon = inputDragonData.inputDragon();

        dragonsCollection.getDragons().add(dragon);

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : add new element to collection";
    }
}
