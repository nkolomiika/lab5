import collections.CommandDictionary;
import collections.DragonCollection;

import untilities.*;

import java.util.*;

import static Colors.OutputColors.ANSI_CYAN;
import static Colors.OutputColors.ANSI_RESET;

public class Main {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        DragonCollection dragons = InitObjects.initDragons();
        InputDragonData inputDragonData = new InputDragonData(input);
        InputDragonDataFromArg inputDragonDataFromArg = new InputDragonDataFromArg();
        InitObjects initObjects = new InitObjects(inputDragonDataFromArg);
        CommandDictionary commands = initObjects.initCommands(dragons);
        CommandRegister commandRegister = new CommandRegister(commands);
        ConsoleWorker consoleWorker = new ConsoleWorker(commands, commandRegister);

        while (true){

            System.out.print(ANSI_CYAN + "Enter command: " + ANSI_RESET);
            String command = input.nextLine();
            consoleWorker.executeInputCommand(command);

        }

    }
}

/*
Работа на завтра:

ADD JAVADOCS

Поискать баги в конце дня
+ мбмб начать работу с opencsv (погуглить про либы с csv форматом вообще)

Почистить main, занеся все под класс InitObjects

Если аргумент пустой не надо проверять дальше
{
Enter command: filter_starts_with_description
Input arg is empty
There are no one dragon`s description which starts with this string
}

Нужно чтобы сначала проверялось есть ли в коллекции элементы а потом аргумент
{
remove_by_id
Invalid arguments
No dragon with that id in collection

remove_by_id -123
Input arg must be positive
No dragon with that id in collection
}

Дизайнерская часть
{
add method err in some class which output RED + "error : " + string
}
 */