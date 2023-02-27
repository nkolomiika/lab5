package CommandPackage;

import DragonCharacteristics.Dragon;

import java.util.TreeSet;
import AbstractCommand.AbstractCommand;

/**
 * Class implements command info.
 * Command output in standard output information about collection(type, date of initialization, size of collection etc)
 */
//add date of init and more info about collection
public class Info extends AbstractCommand {

    public Info(String commandName, TreeSet<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {
        System.out.print("CommandPackage.Info{");
        System.out.printf("    Type of collection : %s\n", dragons.getClass().getName());
        System.out.printf("    Size of collection : %d\n", dragons.size());
        System.out.print("}");
    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : output in standard output information about collection(type, date of initialization, size of collection etc)";
    }
}
