package untilities;

import collections.CommandDictionary;
import collections.DragonCollection;
import commands.*;
import superCommand.AbstractCommand;
import untilities.file.DataRegister;

/**\
 * Class of initialization of objects, which use in main method
 */
public class InitObjects {

    private Convector convector;
    private CommandDictionary commandDictionary;
    private DragonCollection dragonCollection;
    private CommandRegister commandRegister;
    private ConsoleWorker consoleWorker;
    private DataRegister dataRegister;
    private InputData inputData;

    public InputData initInputData(){
        return new InputData(dragonCollection);
    }

    public DragonCollection initDragonCollection(){
        return new DragonCollection();
    }

    public ConsoleWorker initConsoleWorker(){
        return new ConsoleWorker(commandRegister, commandDictionary);
    }

    public CommandRegister initCommandRegister(){
        return new CommandRegister(commandDictionary, dragonCollection);
    }

    public DataRegister initDataRegister(){
        return new DataRegister(inputData, commandRegister, consoleWorker);
    }

    public InitObjects(){
        convector = new Convector();
        dragonCollection = this.initDragonCollection();
        inputData = this.initInputData();
        commandDictionary = this.initCommands();
        commandRegister = this.initCommandRegister();
        consoleWorker = this.initConsoleWorker();
        dataRegister = this.initDataRegister();
    }

    /*/**
     * Method initialize new object of DragonCollection class
     * @return DragonCollection
     */
    /*
    public DragonCollection initDragons(){
        return new DragonCollection();
    }*/

    /**
     * Method initialize new object of CommandDictionary class
     * @return CommandDictionary
     */
    public CommandDictionary initCommands(){

        AbstractCommand[] commandsArray = {
                new Add("add", dragonCollection, inputData),
                new AddIfMax("add_if_max", dragonCollection, inputData),
                new AddIfMin("add_if_min", dragonCollection, inputData),
                new Clear("clear", dragonCollection, inputData),
                new CountLessThanAge("count_less_than_age", dragonCollection, inputData),
                new Exit("exit"),
                new FilterContainsName("filter_contains_name", dragonCollection, inputData),
                new FilterStartsWithDescription("filter_starts_with_description", dragonCollection, inputData),
                new Info("info", dragonCollection, inputData),
                new RemoveById("remove_by_id", dragonCollection, inputData),
                new RemoveGreater("remove_greater", dragonCollection, inputData),
                new Show("show", dragonCollection, inputData),
                new UpdateId("update_id", dragonCollection, inputData),
                new ClearConsole("clear_console"),
                //new ExecuteScript("execute_script", dataRegister)
        };

        CommandDictionary commands = new CommandDictionary(convector, commandsArray);
        commands.getCommands().put("help", new Help("help", commands));

        return commands;

    }

    public void addExecuteScript(){
        commandDictionary.getCommands().put("execute_script", new ExecuteScript("execute_script", dataRegister));
    }

    public DataRegister getDataRegister() {
        return dataRegister;
    }

    public Convector getConvector() {
        return convector;
    }

    public CommandDictionary getCommandDictionary() {
        return commandDictionary;
    }

    public DragonCollection getDragonCollection() {
        return dragonCollection;
    }

    public CommandRegister getCommandRegister() {
        return commandRegister;
    }

    public ConsoleWorker getConsoleWorker() {
        return consoleWorker;
    }
}
