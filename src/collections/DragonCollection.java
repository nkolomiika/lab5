package collections;

import dragon.Dragon;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeSet;

/**
 * Class collections of dragons using collection TreeSet, for keeping dragons in application work time
 */
public class DragonCollection {

    private java.time.LocalDateTime creationDate;
    private TreeSet<Dragon> dragonsCollection;

    public DragonCollection() {
        this.dragonsCollection = new TreeSet<>(new CustomComparator());
        this.creationDate = LocalDateTime.now();
    }

    public TreeSet<Dragon> getDragons() {
        return dragonsCollection;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public boolean checkDragonInCollection(long id){
        for (Dragon dragon : dragonsCollection){
            if (dragon.getId() == id) return true;
        }

        return false;
    }
}
