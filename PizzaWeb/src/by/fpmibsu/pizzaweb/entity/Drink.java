package PizzaWeb.src.by.fpmibsu.pizzaweb.entity;
import java.util.Objects;

public class Drink extends Food {
    private Long drinkID;
    private String name;
    private Double capacity;
    private Double price;

    public Drink(Long drinkID, String name, Double capacity, Double price) {
        this.drinkID = drinkID;
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       Drink drink = (
               Drink) o;
        return Objects.equals(drinkID, drink.drinkID) && Objects.equals(name, drink.name) && Objects.equals(capacity, drink.capacity) && Objects.equals(price, drink.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drinkID, name, capacity, price);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkID=" + drinkID +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

    public Long getDrinkID() {
        return drinkID;
    }

    public void setDrinkID(Long drinkID) {
        this.drinkID = drinkID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}