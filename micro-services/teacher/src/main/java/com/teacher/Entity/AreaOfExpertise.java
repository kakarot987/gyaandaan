package com.teacher.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class AreaOfExpertise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long id;

    @NotNull
    @Column
    private String name;

    public AreaOfExpertise() {
    }

    public AreaOfExpertise(String name) {
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
