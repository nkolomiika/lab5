package CommandPackage;

import DragonCharacteristics.Dragon;
import DragonCharacteristics.DragonCharacter;


import java.math.BigInteger;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.UUID;

import AbstractCommand.AbstractCommand;

import static java.lang.Long.parseLong;


//add try+catch

/**
 * Class implements command add.
 * This command add new element to collection
 */
public class Add extends AbstractCommand {

    public Add(String commandName, TreeSet<Dragon> dragons) {
        super(commandName, dragons);
    }

    /**
     * Method use input string from method inputDragon to convert this string in boolean format
     * @param yesNo
     * @return {1, 0, -1}
     */
    public int yesOrNot(String yesNo) {
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

    /**
     * Method set input yield to Dragon element
     * @return Dragon
     */
    public Dragon inputDragon() {

        Dragon inputDragon = new Dragon();
        Scanner in = new Scanner(System.in);

        String generateUUIDNo = String.format("%010d",new BigInteger(UUID.randomUUID().toString().replace("-",""),16));
        inputDragon.setId(parseLong(generateUUIDNo.substring( generateUUIDNo.length() - 10), 10));

        System.out.print("Name = ");
        String name = in.nextLine();
        while(name.length() == 0){
            System.out.println("Input name`s length must be greater than 0");
            name = in.nextLine();
        }
        inputDragon.setName(name);

        System.out.print("Coordinates {\n   x = ");
        inputDragon.getCoordinates().setX(in.nextInt());
        System.out.print("    y = ");
        inputDragon.getCoordinates().setY(in.nextFloat());
        System.out.print("}\n");

        //date init!!!

        System.out.print("Age = ");
        long age = in.nextLong();
        while(age == 0){
            System.out.println("Input age must be greater than 0");
            age = in.nextLong();
        }
        inputDragon.setAge(age);

        System.out.print("Description = ");
        inputDragon.setDescription(in.nextLine());

        System.out.print("Can speak? y/n? ");
        String yesNo = in.nextLine();
        if (yesOrNot(yesNo) != -1) {
            inputDragon.setSpeaking(yesOrNot(yesNo) == 1);
        } else {
            while (yesOrNot(yesNo) == -1) {
                System.out.println("Error input text, try again ^-^");
                System.out.print("Can speak? y/n? ");
                yesNo = in.nextLine();
            }
            inputDragon.setSpeaking(yesOrNot(yesNo) == 1);
        }

        System.out.print("Dragon character? Use variants(evil, good, chaotic evil, fickle)");
        String character = in.nextLine();
        inputDragon.setCharacter(DragonCharacter.valueOf(character.toLowerCase()));

        System.out.print("Input dragon`s head characteristics {\n   Eyes count = ");
        Float eyesCount = in.nextFloat();
        System.out.print("  Tooth count = ");
        int toothCount = in.nextInt();

        return inputDragon;

    }

    @Override
    public void execute() {

        dragons.add(inputDragon());

    }

    @Override
    public String getCommandInfo() {
        return this.getCommandName() + " : add new element to collection";
    }
}
