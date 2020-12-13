package by.bsuir.poit.entity;

import java.util.Objects;

public class Passenger extends User {
    private OrderStatus orderStatus;
    private int seatsCount;

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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
        if (!super.equals(o)) return false;
        Passenger passenger = (Passenger) o;
        return seatsCount == passenger.seatsCount &&
                orderStatus == passenger.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderStatus, seatsCount);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "orderStatus=" + orderStatus +
                ", seatsCount=" + seatsCount +
                ", id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", hash='" + hash + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
