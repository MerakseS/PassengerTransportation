package by.bsuir.poit.entity;

import java.util.Objects;

public class Bus {
    private long id;
    private String numberPlate;
    private String color;
    private int seatsCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = seatsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return id == bus.id &&
                seatsCount == bus.seatsCount &&
                numberPlate.equals(bus.numberPlate) &&
                color.equals(bus.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberPlate, color, seatsCount);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", numberPlate='" + numberPlate + '\'' +
                ", color='" + color + '\'' +
                ", seatsCount=" + seatsCount +
                '}';
    }
}
