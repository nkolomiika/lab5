package dragon;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class Coordinates {
    @CsvBindByName(column = "x", required = true)
    private Integer x;
    @CsvBindByName(column = "y", required = true)
    private Float y; //Поле не может быть null

    public Coordinates(Integer x, Float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                "; y=" + y +
                '}';
    }

    public Integer getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }
}
