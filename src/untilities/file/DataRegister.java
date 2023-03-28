package untilities.file;

import colors.ConsoleOutput;
import exception.IncorrectInputInScriptException;
import untilities.CommandRegister;
import untilities.ConsoleWorker;
import untilities.InitObjects;
import untilities.InputData;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DataRegister {

    private ConsoleWorker consoleWorker;
    private CommandRegister commandRegister;
    private InputData inputData;
    private Map<String, String> parseData;

    public DataRegister(InputData inputData, CommandRegister commandRegister, ConsoleWorker consoleWorker) {
        this.consoleWorker = consoleWorker;
        this.commandRegister = commandRegister;
        this.inputData = inputData;
        parseData = new HashMap<>();
    }

    public void runner(String path) throws IOException, IncorrectInputInScriptException {
        if (FileInit.checkPath(path)) {
            validator(path);
        }
    }

    public void validator(String path) throws IOException, IncorrectInputInScriptException {

        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine().trim();
        String prev;
        inputData.setFileMode(true);

        while (line != null) {
            if (commandRegister.getCommandFromInputCommand(line) != null) {
                String[] command = commandRegister.getCommandFromInputCommand(line);

                if (command[0].equals("add")) {
                    prev = line;
                    line = reader.readLine();
                    if (line == null) {
                        ConsoleOutput.errOutput("Dragon didn`t add to collection");
                        break;
                    }
                    if (line.equals("")) ConsoleOutput.errOutput("Invalid data");
                    else {
                        dataConvertToMap(line);
                        consoleWorker.executeInputCommand(prev);
                    }
                } else if (command[0].equals("update_id")){
                    prev = line;
                    line = reader.readLine();
                    if (line == null) {
                        ConsoleOutput.errOutput("Dragon didn`t update to collection");
                        break;
                    }
                    if (line.equals("")) ConsoleOutput.errOutput("Invalid data");
                    else {
                        dataConvertToMap(line);
                        consoleWorker.executeInputCommand(prev);
                    }
                } else {
                    consoleWorker.executeInputCommand(line);
                }

            }

            line = reader.readLine();
        }

        inputData.setFileMode(false);
    }

    public void dataConvertToMap(String line) {

        String value;
        line = line.substring(1, line.length() - 1) + ";";
        String[] data = new String[10];
        for (int i = 0; i < 10; i++) {
            value = line.contains(";") ? line.substring(0, line.indexOf(";")).trim() : "";
            data[i] = value;
            line = line.replaceFirst(line.substring(0, line.indexOf(";") + 1), "").trim();
        }

        parseData.put("id", data[0]);
        parseData.put("name", data[1]);
        parseData.put("x", data[2]);
        parseData.put("y", data[3]);
        parseData.put("age", data[4]);
        parseData.put("description", data[5]);
        parseData.put("speaking", data[6]);
        parseData.put("characteristic", data[7]);
        parseData.put("countEyes", data[8]);
        parseData.put("countTooth", data[9]);

        /*for (Map.Entry<String, String> element : parseData.entrySet()) {
            value = line.contains(";") ? line.substring(0, line.indexOf(";")).trim() : "";
            value = value.equals("") ? null : value;
            parseData.put(element.getKey(), value);
            line = line.replace(value + ";", "");
        }*/

//        parseData.putIfAbsent("speaking", "");
        inputData.setParseData(parseData);
    }

    /*public Map<String, String> mapInit() {
        return new HashMap<>() {{
            put("id", null);
            put("name", null);
            put("x", null);
            put("y", null);
            put("age", null);
            put("description", null);
            put("speaking", "");
            put("characteristic", null);
            put("countEyes", null);
            put("countTooth", null);
        }};

    }*/

}
