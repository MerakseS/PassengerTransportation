package by.bsuir.poit.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Route {
    private long id;
    private String from;
    private String to;
    private User driver;
    private Bus bus;
    private BigDecimal cost;
    private OffsetDateTime departureDate;
    private Map<User, Integer> passengers = new HashMap<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public OffsetDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(OffsetDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public Map<User, Integer> getPassengers() {
        return passengers;
    }

    public void setPassengers(Map<User, Integer> passengers) {
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id == route.id &&
                Objects.equals(from, route.from) &&
                Objects.equals(to, route.to) &&
                Objects.equals(driver, route.driver) &&
                Objects.equals(bus, route.bus) &&
                Objects.equals(cost, route.cost) &&
                Objects.equals(departureDate, route.departureDate) &&
                Objects.equals(passengers, route.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, driver, bus, cost, departureDate, passengers);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", driver=" + driver +
                ", bus=" + bus +
                ", cost=" + cost +
                ", departureDate=" + departureDate +
                ", passengers=" + passengers +
                '}';
    }
}
