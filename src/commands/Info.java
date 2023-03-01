package commands;

import collections.DragonCollection;

import superCommand.AbstractCommand;

/**
 * Class implements command info.
 * Command output in standard output information about collection(type, date of initialization, size of collection etc)
 */
//add date of init and more info about collection DONE
//some else?
public class Info extends AbstractCommand {

    public Info(String commandName, DragonCollection dragonsCollection) {
        super(commandName, dragonsCollection);
        this.typeOfArg = null;
    }

    @Override
    public void execute() {

        System.out.println("Info about collection{");
        System.out.printf("    Type of collection : %s\n", dragonsCollection.getDragons().getClass().getName());
        System.out.printf("    Size of collection : %d\n", dragonsCollection.getDragons().size());
        System.out.printf("    Date of creation collection : %s\n", dragonsCollection.getCreationDate());
        System.out.println("}");

    }

    @Override
    public String getCommandInfo() {
        return " output in standard output information about collection(type, date of initialization, size of collection etc)";
    }
}
