package main;

import collections.CommandDictionary;
import collections.DragonCollection;

import untilities.*;

import java.util.*;

import static colors.OutputColors.ANSI_CYAN;
import static colors.OutputColors.ANSI_RESET;

public class Main {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        DragonCollection dragons = InitObjects.initDragons();
        InputDragonData inputDragonData = new InputDragonData(input);
        InputDragonDataFromArg inputDragonDataFromArg = new InputDragonDataFromArg();
        InitObjects initObjects = new InitObjects(inputDragonDataFromArg);
        CommandDictionary commands = initObjects.initCommands(dragons);
        CommandRegister commandRegister = new CommandRegister(commands, dragons);
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

Поискать баги в конце дня
+ мбмб начать работу с opencsv (погуглить про либы с csv форматом вообще)

Почистить main, занеся все под класс InitObjects ?

 */