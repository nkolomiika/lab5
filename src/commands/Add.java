package commands;

import Colors.ConsoleOutput;
import Colors.OutputColors;
import collections.DragonCollection;
import dragon.Dragon;
import Colors.ConsoleOutput;


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
        this.typeOfArg = null;
    }

    @Override
    public void execute() {

        Dragon dragon = inputDragonData.inputDragon();

        dragonsCollection.getDragons().add(dragon);

        ConsoleOutput.messageOutput("Dragon added to collection");

    }

    @Override
    public String getCommandInfo() {
        return " add new element to collection";
    }
}
