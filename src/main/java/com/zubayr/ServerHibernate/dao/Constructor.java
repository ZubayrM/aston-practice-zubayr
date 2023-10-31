package com.zubayr.ServerHibernate.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("constructor")
@Data
@Entity
public class Constructor extends Employee {

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Exercise.class)
    @JoinTable(
            name = "Exercise2Employee",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private Set<Constructor> exercises = new HashSet<>();

}
