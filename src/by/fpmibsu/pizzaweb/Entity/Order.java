package src.by.fpmibsu.pizzaweb.Entity;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Objects;

public class Order extends Entity{
    private ArrayList<Drink> drinks;
    private ArrayList<Pizza> pizzas;
    private Boolean status;
    private Date deliveryDate;
    private String paymentMethod;

    public Order(){}

    public Order(ArrayList<Drink> drinks, ArrayList<Pizza> pizzas, Boolean status, Date deliveryDate, String paymentMethod) {
        this.drinks = drinks;
        this.pizzas = pizzas;
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.paymentMethod = paymentMethod;
    }

    public Order(Long orderID, ArrayList<Pizza> pizzas, ArrayList<Drink> drinks, Boolean status, Date deliveryDate, String paymentMethod) {
        super(orderID);
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.paymentMethod = paymentMethod;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> food) {
        this.drinks = food;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
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
        return Objects.equals(drinks, order.drinks) && Objects.equals(pizzas, order.pizzas) && Objects.equals(status, order.status) && Objects.equals(deliveryDate, order.deliveryDate) && Objects.equals(paymentMethod, order.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drinks, pizzas, status, deliveryDate, paymentMethod);
    }

    @Override
    public String toString() {
        return "Order{" +
                "drinks=" + drinks +
                ", pizzas=" + pizzas +
                ", status=" + status +
                ", deliveryDate=" + deliveryDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
