package untilities;

import colors.ConsoleOutput;
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
public class InputData {

    private Scanner inputData;

    public InputData(Scanner inputData) {
        this.inputData = inputData;
    }

    /**
     * Method set input yield to Dragon element from this class`s methods
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

    public String inputEnvVar(){
        
        String env;

        while (true) {
            try {

                System.out.println("Enter name of environment variable: ");
                env = inputData.nextLine().trim();

                if (env.equals("")) throw new InputDataIsEmptyException();
                break;

            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Input env variable can`t be null");
            } catch (InputDataIsEmptyException exception) {
                ConsoleOutput.errOutput("Input length of env variable must be greater than zero");
            }

        }

        return env;

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
                ConsoleOutput.errOutput("Input name can`t be null");
            } catch (InputDataIsEmptyException exception) {
                ConsoleOutput.errOutput("Input name`s length must be greater than zero");
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
                ConsoleOutput.errOutput("Input coordinate must be number and be integer type");
            } catch (IllegalArgumentException exception) {
                ConsoleOutput.errOutput("Incorrect input coordinate");
            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Input name can`t be null");
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
                ConsoleOutput.errOutput("Input coordinate must be number and be integer type");
            } catch (IllegalArgumentException exception) {
                ConsoleOutput.errOutput("Incorrect input coordinate");
            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Input coordinate can`t be null");
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
                ConsoleOutput.errOutput("Input age can`t be null");
            } catch (InputDataMustBePositiveException exception) {
                ConsoleOutput.errOutput("Input age must be positive");
            } catch (NumberFormatException exception) {
                ConsoleOutput.errOutput("Input age must be number and be long type");
            } catch (IllegalArgumentException exception) {
                ConsoleOutput.errOutput("Incorrect input age");
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

                if (description.equals("")) throw new InputDataIsEmptyException();
                break;

            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Input description can`t be null");
            } catch (InputDataIsEmptyException exception) {
                ConsoleOutput.errOutput("Input description length must be greater than zero");
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
        if (yesNo.equals("y")
                || yesNo.equals("yes")
                || yesNo.equals("да")
                || yesNo.equals("true")) return 1;
        else if (yesNo.equals("n")
                || yesNo.equals("no")
                || yesNo.equals("нет")
                || yesNo.equals("false")) return 0;
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
                ConsoleOutput.errOutput("Invalid variant");
            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("You must choose the variant, this yield can`t be null");
            }
        }

        return yesOrNot(canSpeak) == 1;

    }

    public DragonCharacter inputCharacter() {

        String strCharacter;
        DragonCharacter character;

        while (true) {
            try {

                ConsoleOutput.errOutput("Choose dragon`s characteristic from these variants : " + DragonCharacter.getStringOfTittles());
                System.out.print("Characteristic = ");
                strCharacter = inputData.nextLine().trim().toUpperCase().replaceAll(" ", "_");
                character = DragonCharacter.valueOf(strCharacter);

                break;

            } catch (IllegalArgumentException exception) {
                ConsoleOutput.errOutput("Invalid variant of character");
            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Character can`t be null");
            }
        }

        return character;

    }

    private float inputEyesCount() {

        String strEyesCount;
        float eyesCount;

        while (true) {
            try {

                System.out.print("Count of eyes = ");
                strEyesCount = inputData.nextLine().trim();

                eyesCount = Float.parseFloat(strEyesCount);
                if (eyesCount <= 0) throw new InputDataMustBePositiveException();
                break;

            } catch (NumberFormatException exception) {
                ConsoleOutput.errOutput("Invalid input format, please enter float number");
            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Count of eyes can`t be null");
            } catch (IllegalArgumentException exception) {
                ConsoleOutput.errOutput("Incorrect input count of eyes");
            } catch (InputDataMustBePositiveException exception) {
                ConsoleOutput.errOutput("Input count of eyes must be positive");
            }
        }

        return eyesCount;

    }

    private int inputToothCount() {

        String strToothCount;
        int toothCount;

        while (true) {
            try {

                System.out.print("Count of tooth = ");
                strToothCount = inputData.nextLine().trim();

                toothCount = Integer.parseInt(strToothCount);
                if (toothCount <= 0) throw new InputDataMustBePositiveException();
                break;

            } catch (NumberFormatException exception) {
                ConsoleOutput.errOutput("Invalid input format, please enter integer number");
            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Count of tooth can`t be null");
            } catch (IllegalArgumentException exception) {
                ConsoleOutput.errOutput("Incorrect input count of tooth");
            } catch (InputDataMustBePositiveException exception) {
                ConsoleOutput.errOutput("Input count of tooth must be positive");
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
