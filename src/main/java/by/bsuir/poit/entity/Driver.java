package by.bsuir.poit.entity;

import java.util.Objects;

public class Driver extends User {
    private long driverId;
    private Bus bus;

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return driverId == driver.driverId &&
                bus.equals(driver.bus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), driverId, bus);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", bus=" + bus +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                '}';
    }
}
