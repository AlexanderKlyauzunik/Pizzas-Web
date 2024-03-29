package src.by.fpmibsu.pizzaweb.Entity;

import java.util.Objects;

public class Pizza extends Entity{
    private String name;
    private String ingredients;
    private Boolean size;
    private Boolean doughType;
    private Double price;

    private Double weight;
    
    public Pizza(){}

    public Pizza(String name, String ingredients, Boolean size, Boolean doughType, Double price, Double weight) {
        this.name = name;
        this.ingredients = ingredients;
        this.size = size;
        this.doughType = doughType;
        this.price = price;
        this.weight = weight;
    }

    public Pizza(Long pizzaId, String name, String ingredients, Boolean size, Boolean doughType, Double price, Double weight) {
        super(pizzaId);
        this.weight = weight;
        this.name = name;
        this.ingredients = ingredients;
        this.size = size;
        this.doughType = doughType;
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Long getPizzaId() {
        return this.getId();
    }

    public void setPizzaId(Long pizzaId) {
        this.setId(pizzaId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Boolean getSize() {
        return size;
    }

    public void setSize(Boolean size) {
        this.size = size;
    }

    public Boolean getDoughType() {
        return doughType;
    }

    public void setDoughType(Boolean doughType) {
        this.doughType = doughType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(name, pizza.name) && Objects.equals(ingredients, pizza.ingredients) && Objects.equals(size, pizza.size) && Objects.equals(doughType, pizza.doughType) && Objects.equals(price, pizza.price) && Objects.equals(weight, pizza.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ingredients, size, doughType, price, weight);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", size=" + size +
                ", doughType=" + doughType +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}