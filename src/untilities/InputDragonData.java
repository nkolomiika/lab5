package untilities;

import dragon.Coordinates;
import dragon.Dragon;
import dragon.DragonCharacter;
import dragon.DragonHead;
import exception.InputDataIsEmptyException;
import exception.InputDataMustBePositiveException;
import exception.ThirdVariantOfAnswerException;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.Long.parseLong;

/**
 * Class includes methods, which return input yield to class Dragon element
 */
public class InputDragonData {

    private Scanner inputData;

    public InputDragonData(Scanner inputData) {
        this.inputData = inputData;
    }

    /**
     * Method set input yield to Dragon element from this class`s methods
     *
     * @return Dragon
     */
    public Dragon inputDragon() {

        return new Dragon(
                this.inputName(),
                this.inputCoordinates(),
                this.inputAge(),
                this.inputDescription(),
                this.canSpeak(),
                this.inputCharacter(),
                this.inputDragonHead()
        );

    }

    public Long inputId() {

        String strId;
        long id;

        while (true) {
            try {

                strId = inputData.nextLine().trim();
                id = Long.parseLong(strId);

                if (id <= 0) throw new InputDataMustBePositiveException();
                break;

            } catch (NumberFormatException exception) {
                System.out.println("Input id must be number and be long type");
            } catch (InputDataMustBePositiveException exception) {
                System.out.println("Input id must be positive");
            } catch (NoSuchElementException exception) {
                System.out.println("Input element can`t null");
            } catch (IllegalArgumentException exception) {
                System.out.println("Invalid format of yield");
            }
        }

        return id;

    }

    public String inputName() {

        String name;

        while (true) {
            try {

                System.out.print("Name = ");
                name = inputData.nextLine().trim();

                if (name.equals("")) throw new InputDataIsEmptyException();
                break;

            } catch (NoSuchElementException exception) {
                System.out.println("Input name can`t be null");
            } catch (InputDataIsEmptyException exception) {
                System.out.println("Input name`s length must be greater than zero");
            }

        }

        return name;

    }

    private int inputX() {

        String strX;
        int x;

        while (true) {
            try {

                System.out.print("Input x = ");
                strX = inputData.nextLine().trim();
                x = Integer.parseInt(strX);

                break;

            } catch (NumberFormatException exception) {
                System.out.println("Input coordinate must be number and be integer type");
            } catch (IllegalArgumentException exception) {
                System.out.println("Incorrect input coordinate");
            } catch (NoSuchElementException exception) {
                System.out.println("Input name can`t be null");
            }
        }

        return x;

    }

    private float inputY() {

        String strY;
        float y;

        while (true) {
            try {

                System.out.print("Input y = ");
                strY = inputData.nextLine().trim();
                y = Float.parseFloat(strY);

                break;

            } catch (NumberFormatException exception) {
                System.out.println("Input coordinate must be number and be integer type");
            } catch (IllegalArgumentException exception) {
                System.out.println("Incorrect input coordinate");
            } catch (NoSuchElementException exception) {
                System.out.println("Input coordinate can`t be null");
            }
        }

        return y;

    }

    public Coordinates inputCoordinates() {

        int x = inputX();
        float y = inputY();

        return new Coordinates(x, y);

    }

    public long inputAge() {

        String strAge;
        long age;

        while (true) {
            try {

                System.out.print("Age = ");
                strAge = inputData.nextLine().trim();
                age = Long.parseLong(strAge);

                if (age <= 0) throw new InputDataMustBePositiveException();
                break;

            } catch (NoSuchElementException exception) {
                System.out.println("Input age can`t be null");
            } catch (InputDataMustBePositiveException exception) {
                System.out.println("Input age must be positive");
            } catch (NumberFormatException exception) {
                System.out.println("Input age must be number and be long type");
            } catch (IllegalArgumentException exception) {
                System.out.println("Incorrect input age");
            }
        }

        return age;

    }

    public String inputDescription() {

        String description;

        while (true) {
            try {

                System.out.print("Description = ");
                description = inputData.nextLine().trim();

                break;

            } catch (NoSuchElementException exception) {
                System.out.println("Input description can`t be null");
            }
        }

        return description;

    }

    /**
     * Method use input string from method canSpeak to convert this string in boolean format
     *
     * @param yesNo
     * @return {1, 0, -1}
     */
    private int yesOrNot(String yesNo) {
        if (yesNo.compareToIgnoreCase("y") == 1
                || yesNo.compareToIgnoreCase("yes") == 1
                || yesNo.compareToIgnoreCase("да") == 1
                || yesNo.compareToIgnoreCase("true") == 1) return 1;
        else if (yesNo.compareToIgnoreCase("n") == 1
                || yesNo.compareToIgnoreCase("no") == 1
                || yesNo.compareToIgnoreCase("нет") == 1
                || yesNo.compareToIgnoreCase("false") == 1) return 0;
        return -1;
    }

    public boolean canSpeak() {

        String canSpeak;
        //int flag;

        while (true) {
            try {

                System.out.print("Can dragon speak? y/n? ");
                canSpeak = inputData.nextLine().trim();

                if (yesOrNot(canSpeak) == -1) throw new ThirdVariantOfAnswerException();
                //flag = yesOrNot(canSpeak);
                break;

            } catch (ThirdVariantOfAnswerException exception) {
                System.out.println("Invalid variant");
            } catch (NoSuchElementException exception) {
                System.out.println("You must choose the variant, this yield can`t be null");
            }
        }

        return yesOrNot(canSpeak) == 1;

    }

    public DragonCharacter inputCharacter() {

        String strCharacter;

        while (true) {
            try {

                System.out.println("Choose dragon`s characteristic from these variants : " + DragonCharacter.getStringOfTittles());
                System.out.print("Characteristic = ");
                strCharacter = inputData.nextLine().trim().toUpperCase().replaceAll(" ", "_");
                //characteristic = DragonCharacter.valueOf(strCharacteristic);

                break;

            } catch (IllegalArgumentException exception) {
                System.out.println("Invalid variant of character");
            } catch (NoSuchElementException exception) {
                System.out.println("Character can`t be null");
            }
        }

        return DragonCharacter.valueOf(strCharacter);

    }

    private float inputEyesCount() {

        String strEyesCount;
        float eyesCount;

        while (true) {
            try {

                System.out.println("Count of eyes = ");
                strEyesCount = inputData.nextLine().trim();

                eyesCount = Float.parseFloat(strEyesCount);
                if (eyesCount <= 0) throw new InputDataMustBePositiveException();
                break;

            } catch (NumberFormatException exception) {
                System.out.println("Invalid input format, please enter float number");
            } catch (NoSuchElementException exception) {
                System.out.println("Count of eyes can`t be null");
            } catch (IllegalArgumentException exception) {
                System.out.println("Incorrect input count of eyes");
            } catch (InputDataMustBePositiveException exception) {
                System.out.println("Input count of eyes must be positive");
            }
        }

        return eyesCount;

    }

    private int inputToothCount() {

        String strToothCount;
        int toothCount;

        while (true) {
            try {

                System.out.println("Count of eyes = ");
                strToothCount = inputData.nextLine().trim();

                toothCount = Integer.parseInt(strToothCount);
                if (toothCount <= 0) throw new InputDataMustBePositiveException();
                break;

            } catch (NumberFormatException exception) {
                System.out.println("Invalid input format, please enter integer number");
            } catch (NoSuchElementException exception) {
                System.out.println("Count of tooth can`t be null");
            } catch (IllegalArgumentException exception) {
                System.out.println("Incorrect input count of tooth");
            } catch (InputDataMustBePositiveException exception) {
                System.out.println("Input count of tooth must be positive");
            }
        }

        return toothCount;

    }

    public DragonHead inputDragonHead() {

        float eyesCount = inputEyesCount();
        int toothCount = inputToothCount();

        return new DragonHead(eyesCount, toothCount);

    }

}
