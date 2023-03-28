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

        while (true) {

            try{
                System.out.print(ANSI_CYAN + "Enter command: " + ANSI_RESET);
                String command = input.nextLine();
                initObjects.getConsoleWorker().executeInputCommand(command);
            } catch (NoSuchElementException e){
                ConsoleOutput.errOutput("Line not found\nConsole application closed");
                System.exit(0);
            }

        }

    }
}

/*
Работа на завтра:

начать работу с opencsv +
добавить парсер csv -> java class

 */