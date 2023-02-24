import java.util.HashMap;
import java.util.Map;

/**
 * Класс для хранения в словаре команд
 */
public class CommandDictionary {

    private Map<String, AbstractCommand> commands;

    public Map<String, AbstractCommand> getCommands() {
        return commands;
    }

    /**
     * Конструктор, в котором создается словарь команд(ключ название команды) + добавление в словарь команд, указанных в параметрах конструктора
     * @param commands
     */
    public CommandDictionary(AbstractCommand... commands){
        this.commands = new HashMap<>();
        for(AbstractCommand command: commands){
            this.commands.put(command.getCommandName(), command);
        }
    }

    /**
     * Проверка существует ли команда с заданным названием + выполняет метод execute() в случае, если такая команда есть
     * @param commandName
     */
    public void executeCommand(String commandName){
        if (commands.get(commandName) != null) commands.get(commandName).execute();
        //else System.out.println("Введенная команда неверна. Попробуйте снова :3");
    }

}
