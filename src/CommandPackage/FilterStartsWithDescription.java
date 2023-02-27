package CommandPackage;

import DragonCharacteristics.Dragon;
import java.util.*;
import AbstractCommand.AbstractCommand;

/**
 * Class implements command filter_starts_with_description description.
 * Command output elements, which start with input string
 */
//add try+catch
public class FilterStartsWithDescription extends AbstractCommand {

    public FilterStartsWithDescription(String commandName, TreeSet<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {

        Scanner in = new Scanner(System.in);
        List<String> textFromConsole = Arrays.asList(in.nextLine().split(" "));
        List<List<String>> textFromDescription = new ArrayList<>();


        for (Dragon entry : dragons) {
            textFromDescription.add(Arrays.asList(entry.getDescription().split(" ")));
        }

        for (String str : textFromConsole) {
            if (str.equals("")) textFromConsole.remove(0);
            else break;
        }

        for (List<String> text : textFromDescription) {
            for (String str : text) {
                if (str.equals("")) text.remove(0);
                else break;
            }
        }

        List<List<String>> tmp = new ArrayList<>();
        for (List<String> text : textFromDescription) {
            int flag = 0;
            if (text.size() > textFromConsole.size()) {
                for (int i = 0; i < textFromConsole.size(); i++) {
                    if (!textFromConsole.get(i).equals(text.get(i))) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) tmp.add(text);
            }
        }
        if (tmp.size() == 0)
            System.out.println("There is no one description, which includes this string");
        else {
            System.out.printf("There are %d matches :\n", tmp.size());
            for (List<String> text : tmp) {
                System.out.printf("    %s\n", String.join(" ", text));
            }
        }

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : output elements, which start with input string";
    }
}
