package src.by.fpmibsu.pizzaweb.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

public class Order extends Entity{
    private LinkedList<Entity> food;
    private Boolean status;
    private Date deliveryDate;
    private String paymentMethod;

    public Order(Long orderID,LinkedList<Entity> food, Boolean status, Date deliveryDate, String paymentMethod) {
        super(orderID);
        this.food = food;
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.paymentMethod = paymentMethod;
    }

    public LinkedList<Entity> getFood() {
        return food;
    }

    public void setFood(LinkedList<Entity> food) {
        this.food = food;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(food, order.food) && Objects.equals(status, order.status)  && Objects.equals(deliveryDate, order.deliveryDate) && Objects.equals(paymentMethod, order.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, status, deliveryDate, paymentMethod);
    }

    @Override
    public String toString() {
        return "Order{" +
                "food=" + food +
                ", status=" + status +
                ", deliveryDate=" + deliveryDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
