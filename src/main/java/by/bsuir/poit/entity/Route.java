package by.bsuir.poit.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

public class Route {
    private long id;
    private String from;
    private String to;
    private User driver;
    private BigDecimal cost;
    private OffsetDateTime departureDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id == route.id &&
                from.equals(route.from) &&
                to.equals(route.to) &&
                Objects.equals(driver, route.driver) &&
                cost.equals(route.cost) &&
                departureDate.equals(route.departureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, driver, cost, departureDate);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", driver=" + driver +
                ", cost=" + cost +
                ", departureDate=" + departureDate +
                '}';
    }
}
