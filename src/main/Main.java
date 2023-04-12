package main;

import collections.CommandDictionary;
import collections.DragonCollection;

import colors.ConsoleOutput;
import exception.IncorrectInputInScriptException;
import untilities.*;

import java.io.IOException;
import java.util.*;

import static colors.OutputColors.ANSI_CYAN;
import static colors.OutputColors.ANSI_RESET;

public class Main {

    public static void main(String[] args) throws IncorrectInputInScriptException, IOException {

        Scanner input = new Scanner(System.in);
        InitObjects initObjects = new InitObjects();
        initObjects.addExecuteScript();
        boolean flag = false;

        initObjects.initDragonCollection().setDragonsCollection(initObjects.getParse().parseInputCSV());

        while (true) {

            try{
                System.out.print(ANSI_CYAN + "Enter command: " + ANSI_RESET);
                String command = input.nextLine();
                initObjects.getConsoleWorker().executeInputCommand(command);
                if (initObjects.getCommandDictionary().getCommands().get("exit").isClosed()) break;
                initObjects.getDataRegister().clearArrPaths();
            } catch (NoSuchElementException e){
                flag = true;
            }
            if (flag) {
                ConsoleOutput.errOutput("Line not found\nConsole application closed");
                break;
            }
        }

    }
}

/*
Работа на завтра:

начать работу с opencsv +
добавить парсер csv -> java class

 */