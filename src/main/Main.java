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
        InputData inputData = new InputData(input);
        Convector convector = new Convector();
        InitObjects initObjects = new InitObjects(convector);
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

начать работу с opencsv +
добавить парсер csv -> java class

Почистить main, занеся все под класс InitObjects ?

 */