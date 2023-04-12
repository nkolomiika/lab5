package commands;

import colors.ConsoleOutput;
import exception.IncorrectInputInScriptException;
import superCommand.AbstractCommand;
import superCommand.TypeOfArguments;
import untilities.ConsoleWorker;
import untilities.file.DataRegister;
import untilities.file.ToCSV;

import java.io.IOException;

public class Save extends AbstractCommand {

    private ToCSV parseToCSV;

    public Save(String commandName, ToCSV parseToCSV) {
        super(commandName);
        this.typeOfArg = TypeOfArguments.NULL;
        this.parseToCSV = parseToCSV;
    }

    @Override
    public void execute() throws IOException {
        parseToCSV.runner();
        ConsoleOutput.messageOutput("Collection saved");
    }

    @Override
    public String getCommandInfo() {
        return " save collection in the file";
    }
}

