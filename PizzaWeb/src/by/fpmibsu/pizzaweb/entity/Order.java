package PizzaWeb.src.by.fpmibsu.pizzaweb.entity;


import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

public class Order {
    private Long orderID;
    private LinkedList<Food> food;
    private Boolean status;
    private Double price;
    private Date deliveryDate;
    private String paymentMethod;

    public Order(LinkedList<Food> food, Boolean status, Double price, Date deliveryDate, String paymentMethod) {
        this.food = food;
        this.status = status;
        this.price = price;
        this.deliveryDate = deliveryDate;
        this.paymentMethod = paymentMethod;
    }

    public LinkedList<Food> getFood() {
        return food;
    }

    public void setFood(LinkedList<Food> food) {
        this.food = food;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
        return Objects.equals(food, order.food) && Objects.equals(status, order.status) && Objects.equals(price, order.price) && Objects.equals(deliveryDate, order.deliveryDate) && Objects.equals(paymentMethod, order.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, status, price, deliveryDate, paymentMethod);
    }

    @Override
    public String toString() {
        return "Order{" +
                "food=" + food +
                ", status=" + status +
                ", price=" + price +
                ", deliveryDate=" + deliveryDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
