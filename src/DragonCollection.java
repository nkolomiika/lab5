import DragonCharacteristics.Dragon;

import java.util.Set;
import java.util.TreeSet;

public class DragonCollection {

    private Set<Dragon> dragons;

    public DragonCollection(){
        this.dragons = new TreeSet<>();
    }

    public Set<Dragon> getDragons() {
        return dragons;
    }

}
