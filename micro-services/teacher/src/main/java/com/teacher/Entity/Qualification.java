package com.teacher.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long id;

    @NotNull
    @Column
    private String name;

    public Qualification() {
    }

    public Qualification(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
