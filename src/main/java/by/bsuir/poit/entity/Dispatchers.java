package by.bsuir.poit.entity;

import java.util.Objects;

public class Dispatchers extends User {
    private long dispatcherId;

    public long getDispatcherId() {
        return dispatcherId;
    }

    public void setDispatcherId(long dispatcherId) {
        this.dispatcherId = dispatcherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dispatchers that = (Dispatchers) o;
        return dispatcherId == that.dispatcherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dispatcherId);
    }

    @Override
    public String toString() {
        return "Dispatchers{" +
                "dispatcherId=" + dispatcherId +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                '}';
    }
}
