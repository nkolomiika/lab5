package untilities.file;

import colors.ConsoleOutput;
import untilities.InputData;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class FileInit {

    private InputData inputData;

    public FileInit(InputData inputData) {
        this.inputData = inputData;
    }

    /*public File getFile() {

        String path = this.getFileName();

        if (path != null) {
            File file = new File(path);
            if (!file.canRead()) {
                ConsoleOutput.errOutput("Access denied");
                return null;
            }
            return file;
        }
        return null;
    }*/

    public String getFileName() {

        String env = inputData.inputEnvVar();
        String path;

        if (System.getenv().get(env) == null) {
            ConsoleOutput.errOutput("Env var with this name is absent");
            return null;
        } else {
            path = System.getenv().get(env);
            return checkPath(path) && checkFileFormat(path) ? path : null;
        }
    }

    public static boolean checkPath(String path){
        if (isValidPath(path)){
            File file = new File(path);
            return file.canRead();
        }
        return false;
    }

    public static boolean isValidPath(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex) {
            ConsoleOutput.errOutput("Invalid file path");
            return false;
        }
        return true;
    }

    public static boolean checkFileFormat(String path) {

        int dotIndex = path.lastIndexOf(".");

        if (dotIndex != -1
                && path.substring(dotIndex + 1).equals("csv")) {
            return true;
        }

        ConsoleOutput.errOutput("Invalid file format, use csv");
        return false;

    }

}
