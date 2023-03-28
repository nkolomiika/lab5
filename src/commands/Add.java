package commands;

import colors.ConsoleOutput;
import collections.DragonCollection;
import dragon.Dragon;


import exception.IncorrectInputInScriptException;
import superCommand.AbstractCommand;
import untilities.InputData;

import static java.lang.Long.parseLong;


//add try+catch

/**
 * Class implements command add.
 * This command add new element to collection
 */
public class Add extends AbstractCommand {

    public Add(String commandName, DragonCollection dragonsCollection, InputData inputData) {
        super(commandName, dragonsCollection, inputData);
        this.typeOfArg = null;
    }

    @Override
    public void execute() throws IncorrectInputInScriptException {

        Dragon dragon = inputDragonData.inputDragon();

        if (dragon != null) {
            dragonsCollection.getDragons().add(dragon);
            ConsoleOutput.messageOutput("Dragon added to collection");
        } else {
            ConsoleOutput.errOutput("Dragon didn`t add to collection");
        }

    }

    @Override
    public String getCommandInfo() {
        return " add new element to collection";
    }
}
