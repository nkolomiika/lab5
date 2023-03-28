package commands;

import collections.CustomComparator;
import collections.DragonCollection;
import dragon.Dragon;
import exception.DragonCollectionIsEmptyException;
import superCommand.AbstractCommand;
import superCommand.TypeOfArguments;
import untilities.InputData;

import java.util.*;

/**
 * Class implements command filter_contains_name name.
 * Command output elements, value of field name contains input string
 */
public class FilterContainsName extends AbstractCommand {

    public FilterContainsName(String commandName, DragonCollection dragonsCollection, InputData inputData) {
        super(commandName, dragonsCollection, inputData);
        this.typeOfArg = TypeOfArguments.STRING;
    }

    @Override
    public void execute(String inputName) {


        Set<Dragon> str = new TreeSet<>(new CustomComparator());

        for (Dragon dragon : this.dragonsCollection.getDragons()) {
            int lengthOfDragonName = dragon.getName().length();
            for (int i = 0; i < lengthOfDragonName; i++) {

                if (inputName.length() <= lengthOfDragonName) {
                    if (i + inputName.length() <= lengthOfDragonName) {

                        int count = 0;

                        for (int j = 0; j < inputName.length(); j++) {
                            if (Character.toLowerCase(dragon.getName().charAt(i + j)) == Character.toLowerCase(inputName.charAt(j)))
                                count++;
                        }

                        if (count == inputName.length())
                            str.add(dragon);

                    } else
                        break;
                } else
                    break;

            }
        }

        for (Dragon dragon : str) {
            System.out.println(dragon.toString());
        }
        if (str.size() == 0)
            System.out.println("No one dragon`s name contains this string");

    }

    @Override
    public String getCommandInfo() {
        return " output elements, value of field name contains input string";
    }
}
