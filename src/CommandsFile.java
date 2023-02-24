import DragonCharacteristics.Dragon;
import DragonCharacteristics.DragonCharacter;

import java.lang.reflect.Array;
import java.util.*;

class Help extends AbstractCommand {

    public Help(String commandName, Map<String, AbstractCommand> commands) {
        super(commandName, commands);
    }

    @Override
    public void execute() {
        for (var entry : commands.entrySet()) {
            System.out.println(entry.getValue().getInfoCommandInfo());
        }
    }

    @Override
    String getInfoCommandInfo() {
        return this.getCommandName() + " : output information about unlocked commands";
    }
}

//add date of init and more info about collection
class Info extends AbstractCommand {

    public Info(String commandName, Set<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {
        System.out.print("{");
        System.out.printf("    Type of collection : %s\n", dragons.getClass().getName());
        System.out.printf("    Size of collection : %d\n", dragons.size());
        System.out.print("}");
    }

    @Override
    String getInfoCommandInfo() {
        return this.getCommandName() + " : output in standard output information about collection(type, date of initialization, size of collection etc)";
    }
}

class Show extends AbstractCommand {

    public Show(String commandName, Set<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {
        for (Dragon dragon : this.dragons) {
            System.out.println(dragon.toString());
        }
    }

    @Override
    String getInfoCommandInfo() {
        return this.getCommandName() + " : output in standard output all elements of collection in string representation";
    }
}

//add try+catch
class Add extends AbstractCommand {

    public Add(String commandName, Set<Dragon> dragons) {
        super(commandName, dragons);
    }

    public int yesOrNot(String yesNo) {
        if (yesNo.compareToIgnoreCase("y") == 1
                || yesNo.compareToIgnoreCase("yes") == 1
                || yesNo.compareToIgnoreCase("да") == 1
                || yesNo.compareToIgnoreCase("true") == 1) return 1;
        else if (yesNo.compareToIgnoreCase("n") == 1
                || yesNo.compareToIgnoreCase("no") == 1
                || yesNo.compareToIgnoreCase("нет") == 1
                || yesNo.compareToIgnoreCase("false") == 1) return 0;
        return -1;
    }

    @Override
    public void execute() {

        Dragon inputDragon = new Dragon();
        Scanner in = new Scanner(System.in);

        System.out.print("id = ");
        inputDragon.setId(in.nextLong());

        System.out.print("Name = ");
        inputDragon.setName(in.nextLine());

        System.out.print("Coordinates {\n   x = ");
        inputDragon.getCoordinates().setX(in.nextInt());
        System.out.print("    y = ");
        inputDragon.getCoordinates().setY(in.nextFloat());
        System.out.print("}\n");

        //date init!!!

        System.out.print("Age = ");
        inputDragon.setAge(in.nextLong());

        System.out.print("Description = ");
        inputDragon.setDescription(in.nextLine());

        System.out.print("Can speak? y/n? ");
        String yesNo = in.nextLine();
        if (yesOrNot(yesNo) != -1) {
            inputDragon.setSpeaking(yesOrNot(yesNo) == 1);
        } else {
            while (yesOrNot(yesNo) == -1) {
                System.out.println("Error input text, try again ^-^");
                System.out.print("Can speak? y/n? ");
                yesNo = in.nextLine();
            }
            inputDragon.setSpeaking(yesOrNot(yesNo) == 1);
        }

        System.out.print("Dragon character? Use variants(evil, good, chaotic evil, fickle)");
        String character = in.nextLine();
        inputDragon.setCharacter(DragonCharacter.valueOf(character));

        System.out.print("Input dragon`s head characteristics {\n   Eyes count = ");
        Float eyesCount = in.nextFloat();
        System.out.print("  Tooth count = ");
        int toothCount = in.nextInt();

    }

    @Override
    String getInfoCommandInfo() {
        return this.getCommandName() + " : add new element in collection";
    }
}

//add try+catch
class FilterStartsWithDescription extends AbstractCommand {

    public FilterStartsWithDescription(String commandName, Set<Dragon> dragons) {
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
    String getInfoCommandInfo() {
        return this.getCommandName() + " : output elements, which start with input string";
    }
}

//add try+catch
class CountLessThaAge extends AbstractCommand {

    public CountLessThaAge(String commandName, Set<Dragon> dragons) {
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
    String getInfoCommandInfo() {
        return this.getCommandName() + " : output count of elements, which age lower than input parameter";
    }
}

class FilterContainsName extends AbstractCommand {

    public FilterContainsName(String commandName, Set<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {

        Scanner in = new Scanner(System.in);
        String inputName = in.nextLine();
        List<Dragon> tmp = new ArrayList<>();

        first:
        for (Dragon dragon : this.dragons) {
            second:
            for (int i = 0; i < dragon.getName().length(); i++) {
                if (inputName.length() > dragon.getName().length()) continue first;
                else {
                    if (i + inputName.length() > dragon.getName().length()) continue first;
                    else {
                        int count = 0;
                        for (int j = 0; j < inputName.length(); j++) {
                            if(dragon.getName().charAt(i+j) != inputName.charAt(j)) continue second;
                            count ++;
                        }
                        if (count == inputName.length()) {
                            tmp.add(dragon);
                            continue first;
                        }
                    }
                }
            }
        }

        for (Dragon dragon : tmp) {
            System.out.println(dragon.toString());
        }

    }

    @Override
    String getInfoCommandInfo() {
        return this.getCommandName() + " : output elements, value of field name contains input string";
    }
}

//add comparator+comparable for objects sort, then remove
//didn`t do
class RemoveGreater extends  AbstractCommand{

    public RemoveGreater(String commandName, Set<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {

    }

    @Override
    String getInfoCommandInfo() {
        return this.getCommandName() + " : remove elements that don`t exceed input element";
    }
}

class AddIfMin extends AbstractCommand{

    public AddIfMin(String commandName, Set<Dragon> dragons) {
        super(commandName, dragons);
    }

    @Override
    public void execute() {

    }

    @Override
    String getInfoCommandInfo() {
        return this.getCommandName() + " : ";
    }
}

//add try+catch
class RemoveById extends AbstractCommand{

    public RemoveById(String commandName, Set<Dragon> dragons) {
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
        }
        else{
            System.out.println("Ooops, your dragon collection is empty ~(\"-\"~) ");
        }
    }

    @Override
    String getInfoCommandInfo() {
        return this.getCommandName() + " : remove element by input id";
    }
}
