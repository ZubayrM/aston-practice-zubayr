package com.zubayr.ServerHibernate.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "department")
    private ArrayList<Constructor> employees = new ArrayList<>();

}
