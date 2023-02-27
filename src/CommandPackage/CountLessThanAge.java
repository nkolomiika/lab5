package CommandPackage;

import DragonCharacteristics.Dragon;
import AbstractCommand.AbstractCommand;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Class implements command count_less_than_age age.
 * Command output count of elements, which age lower than input parameter
 */
//add try+catch
public class CountLessThanAge extends AbstractCommand {

    public CountLessThanAge(String commandName, TreeSet<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {

        int count = 0;
        Scanner in = new Scanner(System.in);
        int inputAge = in.nextInt();

        for (Dragon dragon : dragons) {
            if (dragon.getAge() <= inputAge) count++;
        }
        if (count == 0) System.out.println("All dragons older than this age");
        else if (count == 1) System.out.println("There is 1 dragon older than this age");
        else System.out.printf("There are %d dragons older than this age", count);

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : output count of elements, which age lower than input parameter";
    }

}
