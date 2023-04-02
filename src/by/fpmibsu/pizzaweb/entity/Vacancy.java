package src.by.fpmibsu.pizzaweb.entity;

import java.util.LinkedList;
import java.util.Objects;

public class Vacancy extends Entity{

    private LinkedList<User> user;
    private Double salary;
    private Integer trial;
    private String description;

    public Vacancy(){}
    public Vacancy(Long vacancyID, LinkedList<User> user, Double salary, Integer trial, String description) {
        super(vacancyID);
        this.user = user;
        this.salary = salary;
        this.trial = trial;
        this.description = description;
    }

    public Long getVacancyID() {
        return this.getId();
    }

    public void setVacancyID(Long vacancyID) {
        this.setId(vacancyID);
    }

    public LinkedList<User> getUser() {
        return user;
    }

    public void setUser(LinkedList<User> user) {
        this.user = user;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getTrial() {
        return trial;
    }

    public void setTrial(Integer trial) {
        this.trial = trial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(user, vacancy.user) && Objects.equals(salary, vacancy.salary) && Objects.equals(trial, vacancy.trial) && Objects.equals(description, vacancy.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, salary, trial, description);
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "user=" + user +
                ", salary=" + salary +
                ", trial=" + trial +
                ", description='" + description + '\'' +
                '}';
    }
}
