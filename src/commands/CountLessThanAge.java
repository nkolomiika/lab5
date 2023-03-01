package commands;

import collections.DragonCollection;
import dragon.Dragon;
import exception.DragonCollectionIsEmptyException;
import superCommand.AbstractCommand;
import superCommand.TypeOfArguments;

/**
 * Class implements command count_less_than_age age.
 * Command output count of elements, which age lower than input parameter
 */
//add try+catch
public class CountLessThanAge extends AbstractCommand {

    public CountLessThanAge(String commandName, DragonCollection dragonsCollection) {
        super(commandName, dragonsCollection);
        this.typeOfArg = TypeOfArguments.LONG;
    }

    @Override
    public void execute(Long argAge) {

        try {

            int count = 0;

            if (dragonsCollection.getDragons().size() == 0) throw new DragonCollectionIsEmptyException();

            for (Dragon dragon : dragonsCollection.getDragons()) {
                if (dragon.getAge() <= argAge) count++;
            }

            if (count == 0) System.out.println("All dragons older than this age");
            else if (count == 1) System.out.println("There is 1 dragon older than this age");
            else System.out.printf("There are %d dragons older than this age", count);

        } catch (DragonCollectionIsEmptyException exception) {
            System.out.println("Dragon collection is empty");
        }

    }

    @Override
    public String getCommandInfo() {
        return " output count of elements, which age lower than input parameter";
    }

}
