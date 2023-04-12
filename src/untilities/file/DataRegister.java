package untilities.file;

import colors.ConsoleOutput;
import exception.IncorrectInputInScriptException;
import untilities.CommandRegister;
import untilities.ConsoleWorker;
import untilities.InitObjects;
import untilities.InputData;

import java.io.*;
import java.util.*;

public class DataRegister {

    private ConsoleWorker consoleWorker;
    private CommandRegister commandRegister;
    private InputData inputData;
    private Map<String, String> parseData;
    private List<String> arrPaths;

    public DataRegister(InputData inputData, CommandRegister commandRegister, ConsoleWorker consoleWorker) {
        this.consoleWorker = consoleWorker;
        this.commandRegister = commandRegister;
        this.inputData = inputData;
        this.parseData = new HashMap<>();
        this.arrPaths = new ArrayList<>();
    }

    /**
     * Run method-checker and check input from parameter file path
     * @param path file path
     */
    public void runner(String path) throws IOException, IncorrectInputInScriptException {
        if (FileInit.checkPath(path)) {
            validator(path);
        }
    }

    /**
     * Check input data, send command line from file to consoleWorker.
     * Check array of paths that have already used with command execute_script and break while if this path doubled.
     * @param path file path
     */
    public void validator(String path) throws IOException, IncorrectInputInScriptException {

        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine().trim();
        String prev;
        inputData.setFileMode(true);
        if (!arrPaths.contains(file.getAbsoluteFile())) {

            arrPaths.add(file.getAbsolutePath());

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
                    } else if (command[0].equals("update_id")) {
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
        }

        inputData.setFileMode(false);

    }

    /**
     * Method convert string data to HashMap(yield, value), then set it in inputData, to work with data
     * @param line string with data about dragon
     */
    public void dataConvertToMap(String line) {

        String value;
        line = line.substring(1, line.length() - 1) + ";";
        String[] data = new String[10];
        for (int i = 0; i < 9; i++) {
            value = line.contains(";") ? line.substring(0, line.indexOf(";")).trim() : "";
            data[i] = value;
            line = line.replaceFirst(line.substring(0, line.indexOf(";") + 1), "").trim();
        }

        //parseData.put("id", data[0]);
        parseData.put("name", data[0]);
        parseData.put("x", data[1]);
        parseData.put("y", data[2]);
        parseData.put("age", data[3]);
        parseData.put("description", data[4]);
        parseData.put("speaking", data[5]);
        parseData.put("characteristic", data[6]);
        parseData.put("countEyes", data[7]);
        parseData.put("countTooth", data[8]);

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

    public void clearArrPaths() {
        this.arrPaths.clear();
    }
}
