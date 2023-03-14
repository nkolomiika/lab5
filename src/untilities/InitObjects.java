package untilities;

import collections.CommandDictionary;
import collections.DragonCollection;
import commands.*;
import superCommand.AbstractCommand;

/**\
 * Class of initialization of objects, which use in main method
 */
public class InitObjects {

    private Convector convector;

    public InitObjects(Convector convector){
        this.convector = convector;
    }

    /**
     * Method initialize new object of DragonCollection class
     * @return DragonCollection
     */
    public static DragonCollection initDragons(){
        return new DragonCollection();
    }

    /**
     * Method initialize new object of CommandDictionary class
     * @return CommandDictionary
     */
    public CommandDictionary initCommands(DragonCollection dragonCollection){

        AbstractCommand[] commandsArray = {
                new Add("add", dragonCollection),
                new AddIfMax("add_if_max", dragonCollection),
                new AddIfMin("add_if_min", dragonCollection),
                new Clear("clear", dragonCollection),
                new CountLessThanAge("count_less_than_age", dragonCollection),
                new Exit("exit"),
                new FilterContainsName("filter_contains_name", dragonCollection),
                new FilterStartsWithDescription("filter_starts_with_description", dragonCollection),
                new Info("info", dragonCollection),
                new RemoveById("remove_by_id", dragonCollection),
                new RemoveGreater("remove_greater", dragonCollection),
                new Show("show", dragonCollection),
                new UpdateId("update_id", dragonCollection),
                new ClearConsole("clear_console")
        };

        CommandDictionary commands = new CommandDictionary(convector, commandsArray);
        commands.getCommands().put("help", new Help("help", commands));

        return commands;

    }

}
