package CommandPackage;

import DragonCharacteristics.Dragon;
import AbstractCommand.AbstractCommand;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Class implements command filter_contains_name name.
 * Command output elements, value of field name contains input string
 */
public class FilterContainsName extends AbstractCommand {

    public FilterContainsName(String commandName, TreeSet<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {

        Scanner in = new Scanner(System.in);
        String inputName = in.nextLine();
        List<Dragon> tmp = new ArrayList<>();

        for (Dragon dragon : this.dragons) {
            int lengthOfDragonName = dragon.getName().length();
            for (int i = 0; i < lengthOfDragonName; i++) {

                if (inputName.length() <= lengthOfDragonName) {
                    if (i + inputName.length() <= lengthOfDragonName) {

                        int count = 0;

                        for (int j = 0; j < inputName.length(); j++) {
                            if (dragon.getName().charAt(i + j) == inputName.charAt(j))
                                count++;
                        }

                        if (count == inputName.length())
                            tmp.add(dragon);

                    }
                    else
                        break;
                }
                else
                    break;

            }
        }

        for (Dragon dragon : tmp) {
            System.out.println(dragon.toString());
        }

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : output elements, value of field name contains input string";
    }
}
