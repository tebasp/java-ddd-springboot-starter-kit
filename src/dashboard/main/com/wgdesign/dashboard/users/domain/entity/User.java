package com.wgdesign.dashboard.users.domain.entity;

import com.wgdesign.dashboard.users.domain.dto.UserCreatedDomainEvent;
import com.wgdesign.shared.domain.AggregateRoot;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "users")
public class User extends AggregateRoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(name = "birth_date")
    private Date birthDate;

    public User() {
    }

    public User(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public static User create(String name, Date birthDate) {
        User user = new User(name, birthDate);

        user.record(new UserCreatedDomainEvent("1", user.name, user.birthDate));

        return user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}