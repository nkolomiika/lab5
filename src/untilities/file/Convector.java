package untilities.file;

import colors.ConsoleOutput;
import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import dragon.DragonCharacter;
import exception.InputDataIsEmptyException;
import exception.InputDataMustBePositiveException;

import java.util.NoSuchElementException;

public class Convector extends AbstractBeanField {

    /**
     * Validate argument, and if true convert it to long type
     * @param strLong Input Long type parameter
     * @return Long
     */
    public Long convertArgToLongType(String strLong) {

        long resLong = 0;
        boolean warning = false;

        try {

            resLong = Long.parseLong(strLong);

            if (resLong <= 0) throw new InputDataMustBePositiveException();

        } catch (NumberFormatException exception) {
            ConsoleOutput.errOutput("Invalid arguments");
            warning = true;
        } catch (InputDataMustBePositiveException exception) {
            ConsoleOutput.errOutput("Input arg must be positive");
            warning = true;
        } catch (NoSuchElementException exception) {
            ConsoleOutput.errOutput("Input arg can`t null");
            warning = true;
        } catch (IllegalArgumentException exception) {
            ConsoleOutput.errOutput("Invalid format of arg");
            warning = true;
        }

        if (warning) return null;

        return resLong;

    }

    /**
     * Check input argument from console
     * @param str Input String type parameter
     * @return String
     */
    public String checkValidStringFromArg(String str) {

        try {

            if (str == null) throw new NoSuchElementException();
            if (str.equals("")) throw new InputDataIsEmptyException();

        } catch (NoSuchElementException exception) {
            ConsoleOutput.errOutput("Input arg can`t be null");
            return null;
        } catch (InputDataIsEmptyException exception) {
            ConsoleOutput.errOutput("Invalid arguments");
            return null;
        }

        return str;

    }

    /**
     * Convert string to enum class`s value
     * @param s String, which will be converted to enum class`s value
     * @return DragonCharacter value of enum class
     */
    @Override
    protected DragonCharacter convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        s = s.toUpperCase().trim();
        DragonCharacter.valueOf(s);
        return DragonCharacter.valueOf(s);
    }
}
