package untilities.file;

import collections.CustomComparator;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvValidationException;
import dragon.Dragon;
import dragon.DragonCharacter;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ParseFromCSV {

    private FileInit fileInit;
    private Convector convector;

    public ParseFromCSV(FileInit fileInit) {
        this.fileInit = fileInit;
        this.convector = new Convector();
    }

    /**
     * Method parse csv data and convert it to dragon class, add new dragon to collection
     * @return TreeSet<Dragon> dragon collection
     */
    public TreeSet<Dragon> parseInputCSV() throws FileNotFoundException {

        String path = fileInit.getFileName();
        //String path = "C:\\Users\\mad_duck\\Documents\\GitHub\\lab5\\test.csv";
        if (path == null) {
            return new TreeSet<>(new CustomComparator());
        }
        CSVReader csvReader = new CSVReader(new FileReader(path));
        TreeSet<Dragon> dragons = new TreeSet<>(new CustomComparator());
        String[] line;

        try {

            while ((line = csvReader.readNext()) != null) {
                line = StringUtils.stripAll(line);
                Dragon dragon = new Dragon();
                dragon.setId(Long.parseLong(line[0]));
                dragon.setName(line[1]);
                dragon.getCoordinates().setX(Integer.parseInt(line[2]));
                dragon.getCoordinates().setY(Float.parseFloat(line[3]));
                dragon.setAge(Long.parseLong(line[4]));
                dragon.setDescription(line[5]);
                dragon.setSpeaking(Boolean.parseBoolean(line[6]));
                dragon.setCharacter(DragonCharacter.valueOf(line[7].trim().toUpperCase()));
                dragon.getHead().setEyesCount(Float.parseFloat(line[8]));
                dragon.getHead().setToothCount(Integer.parseInt(line[9]));
                dragons.add(dragon);
            }

        } catch (CsvValidationException
                 | IOException
                 | NumberFormatException
                 | ArrayIndexOutOfBoundsException
                 | NullPointerException e) {
            System.out.println("Error of parse csv data");
        }

        return dragons;
    }

}
