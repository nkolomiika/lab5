import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner inputData = new Scanner(System.in);


        /*String uniqueID = UUID.randomUUID().toString();
        System.out.println(uniqueID);

        List<String> books = new ArrayList<String>();
        books.add("a");
        books.add("abc");
        books.add("ac");

        //String other = "ac";
        //books.removeIf(b -> b.equals(other));

        for (String str1: books) System.out.printf("el : %s\n", str1);

        String generateUUIDNo = String.format("%010d",new BigInteger(UUID.randomUUID().toString().replace("-",""),16));

        Long.parseLong(generateUUIDNo.substring( generateUUIDNo.length() - 10), 10);
        *///System.out.println( String.format("%010d","AAAA",16));
    }
}