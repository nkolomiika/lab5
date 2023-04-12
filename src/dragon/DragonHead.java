package dragon;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class DragonHead {

    private float eyesCount;

    private int toothCount;

    public DragonHead(float eyesCount, int toothCount) {
        this.eyesCount = eyesCount;
        this.toothCount = toothCount;
    }

    public DragonHead(){}

    @Override
    public String toString() {
        return "DragonHead{" +
                "eyesCount : " + eyesCount +
                ", toothCount : " + toothCount +
                '}';
    }

    public String toCSVHead() {
        return eyesCount +
                ", " + toothCount;
    }

    public Float getEyesCount() {
        return eyesCount;
    }

    public void setEyesCount(float eyesCount) {
        this.eyesCount = eyesCount;
    }

    public Integer getToothCount() {
        return toothCount;
    }

    public void setToothCount(int toothCount) {
        this.toothCount = toothCount;
    }
}
