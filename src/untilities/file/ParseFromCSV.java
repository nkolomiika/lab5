package untilities.file;

import com.opencsv.bean.CsvToBeanBuilder;
import dragon.Dragon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ParseFromCSV {

    private FileInit fileInit;

    public ParseFromCSV(FileInit fileInit){
        this.fileInit = fileInit;
    }

    public List<Dragon> parseInputCSV() throws FileNotFoundException {

        //String path = fileInit.getFileName();
        String path = "C:\\Users\\mad_duck\\Documents\\GitHub\\lab5\\testik.csv";

        List dragons = new CsvToBeanBuilder(new FileReader(path))
                .withType(Dragon.class)
                .build()
                .parse();

        return dragons;

    }

}
