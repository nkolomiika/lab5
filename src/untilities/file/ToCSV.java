package untilities.file;

import collections.DragonCollection;
import dragon.Dragon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class ToCSV {

    private DragonCollection dragons;

    public ToCSV(DragonCollection dragons) {
        this.dragons = dragons;
    }

    /**
     * Method generate unique file name, create csv file, directory if result dir doesn`t exist.
     * With FileOutputStream save dragon collection to created file
     */
    public void runner() throws IOException {

        String generateUUIDNo = String.format("%010d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
        String path = "result";
        File file = new File(path);
        String filePath = generateUUIDNo + ".csv";

        if ((file.exists()
                && !file.isDirectory())
                || (!file.exists())) {

            file.mkdir();

        }

        Files.createFile(Path.of(filePath));
        FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);

        for (Dragon dragon : dragons.getDragons()){

            fileOutputStream.write(dragon.toCSV().getBytes());

        }

    }

}
