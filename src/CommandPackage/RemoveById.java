package CommandPackage;

import DragonCharacteristics.Dragon;

import java.util.Scanner;
import java.util.TreeSet;
import AbstractCommand.AbstractCommand;

/**
 * Class implements command remove_by_id.
 * Command remove element by input id
 */
//add try+catch
public class RemoveById extends AbstractCommand {

    public RemoveById(String commandName, TreeSet<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {
        if (dragons.size() != 0) {
            Scanner in = new Scanner(System.in);
            Long inputId = in.nextLong();

            while (inputId <= 0) {
                System.out.println("Invalid input value, try again o_o");
                inputId = in.nextLong();
            }

            boolean flag = false;
            Dragon tmp = new Dragon();
            while (!flag) {
                for (Dragon dragon : dragons) {
                    if (dragon.getId() == inputId) {
                        tmp = dragon;
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("There are no one dragon with that id, try again (~\"-\")~");
                    inputId = in.nextLong();
                }
            }
        } else {
            System.out.println("Ooops, your dragon collection is empty ~(\"-\"~) ");
        }
    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : remove element by input id";
    }
}
