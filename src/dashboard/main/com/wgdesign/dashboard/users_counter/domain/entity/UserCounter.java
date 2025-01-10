package com.wgdesign.dashboard.users_counter.domain.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
@Table(name = "users_counter")
public class UserCounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer count;

    public UserCounter() {}

    public UserCounter(Integer id, Integer count) {
        this.id = id;
        this.count = count;
    }

    public void increment() {
        this.count++;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UserCounter{" +
                "id=" + id +
                ", count=" + count +
                '}';
    }
}
