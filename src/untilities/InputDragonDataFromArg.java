package untilities;

import exception.InputDataIsEmptyException;
import exception.InputDataMustBePositiveException;

import java.util.NoSuchElementException;

public class InputDragonDataFromArg {

    public Long convertArgToLongType(String strLong) {

        long resLong = 0;

        try {

            resLong = Long.parseLong(strLong);

            if (resLong <= 0) throw new InputDataMustBePositiveException();

        } catch (NumberFormatException exception) {
            System.out.println("Invalid arguments");
            return resLong;
        } catch (InputDataMustBePositiveException exception) {
            System.out.println("Input arg must be positive");
            return resLong;
        } catch (NoSuchElementException exception) {
            System.out.println("Input arg can`t null");
            return resLong;
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid format of arg");
            return resLong;
        }

        return resLong;

}

    public String checkValidStringFromArg(String str) {

        try {

            if (str == null) throw new NoSuchElementException();
            if (str.equals("")) throw new InputDataIsEmptyException();

        } catch (NoSuchElementException exception) {
            System.out.println("Input arg can`t be null");
            return "";
        } catch (InputDataIsEmptyException exception) {
            System.out.println("Input arg is empty");
            return "";
        }

        return str;

    }

}
