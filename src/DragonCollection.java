import DragonCharacteristics.CustomComparator;
import DragonCharacteristics.Dragon;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.TreeSet;

/**
 * TreeSet of dragons
 */
public class DragonCollection {

    private TreeSet<Dragon> dragons;

    public DragonCollection(){
        this.dragons = new TreeSet<>(new CustomComparator());
    }

    public TreeSet<Dragon> getDragons() {
        return dragons;
    }

}
