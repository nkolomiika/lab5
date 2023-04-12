package untilities;

import collections.DragonCollection;
import colors.ConsoleOutput;
import dragon.Coordinates;
import dragon.Dragon;
import dragon.DragonCharacter;
import dragon.DragonHead;
import exception.IncorrectInputInScriptException;
import exception.InputDataIsEmptyException;
import exception.InputDataMustBePositiveException;
import exception.ThirdVariantOfAnswerException;

import java.math.BigInteger;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

import static colors.OutputColors.ANSI_CYAN;
import static colors.OutputColors.ANSI_RESET;
import static java.lang.Long.parseLong;

/**
 * Class includes methods, which return input yield to class Dragon element
 */
public class InputData {
    private boolean fileMode;
    private Scanner inputData;
    private DragonCollection dragonCollection;
    private Map<String, String> parseData;

    public InputData(DragonCollection dragonCollection) {
        this.dragonCollection = dragonCollection;
        this.inputData = new Scanner(System.in);
        fileMode = false;
    }

    /**
     * Method set input yield to Dragon element from this class`s methods
     *
     * @return Dragon
     */
    public Dragon inputDragon() throws IncorrectInputInScriptException {

        Dragon dragon = new Dragon(
                this.inputId(),
                this.inputName(),
                this.inputCoordinates(),
                this.inputAge(),
                this.inputDescription(),
                this.canSpeak(),
                this.inputCharacter(),
                this.inputDragonHead()
        );

        if (dragon.validData()) return dragon;

        return null;
    }

    public void setParseData(Map<String, String> parseData) {
        this.parseData = parseData;
    }

    public long inputId() {

        long id;

        String generateUUIDNo = String.format("%010d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
        id = parseLong(generateUUIDNo.substring(generateUUIDNo.length() - 10), 10);

        return id;
    }

    public String inputEnvVar() {

        String env = "";
        boolean flag = false;

        try {

            System.out.print(ANSI_CYAN + "Enter name of environment variable: " + ANSI_RESET);
            env = inputData.nextLine().trim();

            if (env.equals("")) throw new InputDataIsEmptyException();


        } catch (NoSuchElementException exception) {
            ConsoleOutput.errOutput("Input env variable can`t be null");
        } catch (InputDataIsEmptyException exception) {
            ConsoleOutput.errOutput("Input length of env variable must be greater than zero");
        }

        return env;

    }

    public String inputName() throws IncorrectInputInScriptException {

        String name;
        boolean flag = false;

        while (true) {
            try {
                if (flag) return "";
                if (fileMode) {
                    name = parseData.get("name");
                    if (name.equals("")) return name;
                } else {
                    System.out.print("Name = ");
                    name = inputData.nextLine().trim();
                }

                if (name.equals("")) throw new InputDataIsEmptyException();

                break;

            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Input name can`t be null");
                flag = true;
            } catch (InputDataIsEmptyException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Input name`s length must be greater than zero");
            }

        }

        return name;

    }

    private Integer inputX() throws IncorrectInputInScriptException {

        String strX;
        int x;
        boolean flag = false;

        while (true) {
            try {
                if (flag) return null;
                if (fileMode) {
                    strX = parseData.get("x");
                    if (strX.equals("")) return null;
                } else {
                    System.out.print("Input x = ");
                    strX = inputData.nextLine().trim();
                }

                x = Integer.parseInt(strX);

                break;

            } catch (NumberFormatException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Input coordinate must be number and be integer type");
                if (fileMode) flag = true;
            } catch (IllegalArgumentException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Incorrect input coordinate");
                if (fileMode) flag = true;
            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Input name can`t be null");
                flag = true;
            }
        }

        return x;

    }

    private Float inputY() throws IncorrectInputInScriptException {

        String strY;
        float y;
        boolean flag = false;

        while (true) {
            try {

                if (flag) return null;
                if (fileMode) {
                    strY = parseData.get("y");
                    if (strY.equals("")) return null;
                } else {
                    System.out.print("Input y = ");
                    strY = inputData.nextLine().trim();
                }
                y = Float.parseFloat(strY);

                break;

            } catch (NumberFormatException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Input coordinate must be number and be integer type");
                if (fileMode) flag = true;
            } catch (IllegalArgumentException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Incorrect input coordinate");
                if (fileMode) flag = true;
            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Input coordinate can`t be null");
                flag = true;
            }
        }

        return y;

    }

    public Coordinates inputCoordinates() throws IncorrectInputInScriptException {

        Integer x = inputX();
        Float y = inputY();

        return new Coordinates(x, y);

    }

    public long inputAge() throws IncorrectInputInScriptException {

        String strAge;
        long age;
        boolean flag = false;

        while (true) {
            try {

                if (flag) return -1;
                if (fileMode) {
                    strAge = parseData.get("age");
                    if (strAge.equals("")) return -1;
                } else {
                    System.out.print("Age = ");
                    strAge = inputData.nextLine().trim();
                }

                age = Long.parseLong(strAge);

                if (age <= 0) throw new InputDataMustBePositiveException();
                break;

            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Input age can`t be null");
                flag = true;
            } catch (InputDataMustBePositiveException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Input age must be positive");
                if (fileMode) flag = true;
            } catch (NumberFormatException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Input age must be number and be long type");
                if (fileMode) flag = true;
            } catch (IllegalArgumentException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Incorrect input age");
                if (fileMode) flag = true;
            }
        }

        return age;

    }

    public String inputDescription() throws IncorrectInputInScriptException {

        String description;
        boolean flag = false;

        while (true) {
            try {

                if (flag) return "";
                if (fileMode) {
                    description = parseData.get("description");
                    if (description.equals("")) return description;
                } else {
                    System.out.print("Description = ");
                    description = inputData.nextLine().trim();
                }

                if (description.equals("")) throw new InputDataIsEmptyException();
                break;

            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Input description can`t be null");
                flag = true;
            } catch (InputDataIsEmptyException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Input description length must be greater than zero");
                if (fileMode) flag = true;
            }
        }

        return description;

    }

    /**
     * Method use input string from method canSpeak to convert this string in boolean format
     *
     * @param yesNo input parameter
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
                || yesNo.equals("")
                || yesNo.equals("false")) return 0;
        return -1;
    }

    public boolean canSpeak() throws IncorrectInputInScriptException {

        String canSpeak;
        boolean flag = false;

        while (true) {
            try {

                if (flag) return false;
                if (fileMode) {
                    canSpeak = parseData.get("speaking");
                } else {
                    System.out.print("Can dragon speak? y/n? ");
                    canSpeak = inputData.nextLine().trim();
                }

                if (yesOrNot(canSpeak) == -1 && !fileMode) throw new ThirdVariantOfAnswerException();
                //flag = yesOrNot(canSpeak);
                break;

            } catch (ThirdVariantOfAnswerException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Invalid variant");
                if (fileMode) flag = true;
            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("You must choose the variant, this yield can`t be null");
                flag = true;
            }
        }

        return yesOrNot(canSpeak) == 1;

    }

    public DragonCharacter inputCharacter() throws IncorrectInputInScriptException {

        String strCharacter;
        DragonCharacter character;
        boolean flag = false;

        while (true) {
            try {

                if (flag) return DragonCharacter.ERROR;
                if (fileMode) {
                    strCharacter = parseData.get("characteristic");
                    if (strCharacter.equals("")) return DragonCharacter.ERROR;
                } else {
                    ConsoleOutput.messageOutput("Choose dragon`s characteristic from these variants : " + DragonCharacter.getStringOfTittles());
                    System.out.print("Characteristic = ");
                    strCharacter = inputData.nextLine();
                }
                strCharacter = strCharacter.trim().toUpperCase().replaceAll(" ", "_");
                character = DragonCharacter.valueOf(strCharacter);

                break;

            } catch (IllegalArgumentException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Invalid variant of character");
                if (fileMode) flag = true;
            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Character can`t be null");
                flag = true;
            }
        }

        return character;

    }

    private float inputEyesCount() throws IncorrectInputInScriptException {

        String strEyesCount;
        float eyesCount;
        boolean flag = false;

        while (true) {
            try {

                if (flag) return -1;
                if (fileMode) {
                    strEyesCount = parseData.get("countEyes");
                    if (strEyesCount.equals("")) return -1;
                } else {
                    System.out.print("Count of eyes = ");
                    strEyesCount = inputData.nextLine().trim();
                }

                eyesCount = Float.parseFloat(strEyesCount);
                if (eyesCount <= 0) throw new InputDataMustBePositiveException();
                break;

            } catch (NumberFormatException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Invalid input format, please enter float number");
                if (fileMode) flag = true;
            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Count of eyes can`t be null");
                flag = true;
            } catch (IllegalArgumentException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Incorrect input count of eyes");
                if (fileMode) flag = true;
            } catch (InputDataMustBePositiveException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Input count of eyes must be positive");
                if (fileMode) flag = true;
            }
        }

        return eyesCount;

    }

    private int inputToothCount() throws IncorrectInputInScriptException {

        String strToothCount;
        int toothCount;
        boolean flag = false;

        while (true) {
            try {

                if (flag) return -1;
                if (fileMode) {
                    strToothCount = parseData.get("countTooth");
                    if (strToothCount.equals("")) return -1;
                } else {
                    System.out.print("Count of tooth = ");
                    strToothCount = inputData.nextLine().trim();
                }

                toothCount = Integer.parseInt(strToothCount);
                if (toothCount <= 0) throw new InputDataMustBePositiveException();
                break;

            } catch (NumberFormatException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Invalid input format, please enter integer number");
                if (fileMode) flag = true;
            } catch (NoSuchElementException exception) {
                ConsoleOutput.errOutput("Count of tooth can`t be null");
                flag = true;
            } catch (IllegalArgumentException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Incorrect input count of tooth");
                if (fileMode) flag = true;
            } catch (InputDataMustBePositiveException exception) {
                if (!fileMode) ConsoleOutput.errOutput("Input count of tooth must be positive");
                if (fileMode) flag = true;
            }
        }

        return toothCount;
    }

    public DragonHead inputDragonHead() throws IncorrectInputInScriptException {

        float eyesCount = inputEyesCount();
        int toothCount = inputToothCount();

        return new DragonHead(eyesCount, toothCount);

    }

    public void setFileMode(boolean fileMode) {
        this.fileMode = fileMode;
    }

    public boolean getFileMode() {
        return fileMode;
    }
}
