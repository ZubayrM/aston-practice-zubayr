package com.zubayr.ServerHibernate.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "position")
@NoArgsConstructor
@AllArgsConstructor

public class Employee extends BaseEmployee {

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Double salary;



}
