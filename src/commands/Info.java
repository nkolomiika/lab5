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
    }

    @Override
    public void execute() {

        System.out.print("Info about collection{");
        System.out.printf("    Type of collection : %s\n", dragonsCollection.getDragons().getClass().getName());
        System.out.printf("    Size of collection : %d\n", dragonsCollection.getDragons().size());
        System.out.printf("    Date of creation collection : %s\n", dragonsCollection.getCreationDate());
        System.out.print("}");

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : output in standard output information about collection(type, date of initialization, size of collection etc)";
    }
}
