package untilities.file;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ParseFromCSV {

    private FileInit fileInit;

    public ParseFromCSV(FileInit fileInit){
        this.fileInit = fileInit;
    }

    public void parseInputCSV() throws FileNotFoundException {

        String path = fileInit.getFileName();

        CSVReader reader = new CSVReader(new FileReader(path));

    }

}
