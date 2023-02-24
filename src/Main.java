import DragonCharacteristics.Dragon;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*String uniqueID = UUID.randomUUID().toString();
        System.out.println(uniqueID);*/

        List<String> books = new ArrayList<String>();
        books.add("a");
        books.add("abc");
        books.add("ac");

        //String other = "ac";
        //books.removeIf(b -> b.equals(other));

        for (String str1: books) System.out.printf("el : %s\n", str1);

    }
}