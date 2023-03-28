package commands;

import exception.IncorrectInputInScriptException;
import superCommand.AbstractCommand;
import superCommand.TypeOfArguments;
import untilities.ConsoleWorker;
import untilities.InitObjects;
import untilities.file.DataRegister;
import untilities.file.FileInit;

import java.io.IOException;

//добавить проверку на рекурсию
public class ExecuteScript extends AbstractCommand {

    private DataRegister dataRegister;

    public ExecuteScript(String commandName, DataRegister dataRegister) {
        super(commandName);
        this.typeOfArg = TypeOfArguments.STRING;
        this.dataRegister = dataRegister;
    }

    @Override
    public void execute(String path) throws IOException, IncorrectInputInScriptException {
        dataRegister.runner(path);
    }

    @Override
    public String getCommandInfo() {
        return " read and execute script";
    }
}
