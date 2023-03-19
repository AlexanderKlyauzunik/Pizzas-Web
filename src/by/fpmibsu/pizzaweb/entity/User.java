package src.by.fpmibsu.pizzaweb.entity;

import java.util.LinkedList;
import java.util.Objects;

public class User {
    private Long userId;

    private LinkedList<Address> addresses;

    private Order order;

    private String firstName;

    private String lastName;

    private String password;

    private String Email;

    private String Telephone;

    private Role role;

    public User(Long userId, LinkedList<Address> addresses, Order order, String firstName, String lastName, String password, String email, String telephone, Role role) {
        this.userId = userId;
        this.addresses = addresses;
        this.order = order;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        Email = email;
        Telephone = telephone;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LinkedList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(LinkedList<Address> addresses) {
        this.addresses = addresses;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(addresses, user.addresses) && Objects.equals(order, user.order) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(password, user.password) && Objects.equals(Email, user.Email) && Objects.equals(Telephone, user.Telephone) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, addresses, order, firstName, lastName, password, Email, Telephone, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", addresses=" + addresses +
                ", order=" + order +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", Email='" + Email + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", role=" + role +
                '}';
    }
}
