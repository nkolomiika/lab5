package untilities.file;

import colors.ConsoleOutput;
import untilities.InputData;

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

        } else {
            path = System.getenv().get(env);
            if (isValidPath(path)
                    && checkFileFormat(path)) {
                return path;
            }
        }

        return null;
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

    public static boolean checkFileFormat(String filePath) {

        int dotIndex = filePath.lastIndexOf(".");

        if (dotIndex != -1
                && filePath.substring(dotIndex + 1).equals("csv")) {
            return true;
        }

        ConsoleOutput.errOutput("Invalid file format, use csv");
        return false;

    }

}
