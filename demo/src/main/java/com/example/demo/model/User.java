package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
    @Column
    private Long id;
    @Column
    @NotBlank(message="First name shouldn't be empty")
    @Size(min=2, message="First name must be at least 2 letters long")
    @Pattern(regexp="^[a-zA-Z]*$", message="First name should only contain letters.")
    private String firstName;
    @Column
    @NotBlank(message="Last name shouldn't be empty")
    @Size(min=2, message="Last name must be at least 2 letters long")
    @Pattern(regexp="^[a-zA-Z]*$", message="Last name should only contain letters.")
    private String lastName;
    @Column
    @Min(value=18)
    @Max(value=130)
    private int age;
    @Column
    @NotBlank(message="Email address shouldn't be empty")
    private String emailAddress;

    public User(String firstName, String lastName, int age, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    public User() {}

    public User(User user) {
        this(user.getFirstName(), user.getLastName(), user.getAge(), user.getEmailAddress());
    }

    @Column(name="id")
    public Long getId() {
        return id;
    }

    @Column(name="id")
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name="first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    @Column(name="last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="age")
    public int getAge() {
        return age;
    }

    @Column(name="age")
    public void setAge(int age) {
        this.age = age;
    }

    @Column(name="email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    @Column(name="email_address")
    public void setEmailAddress(String email) {
        this.emailAddress = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAge());
    }
}
