package com.zubayr.ServerHibernate.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Exercise2Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "employee_id")
    private Constructor employeeId;

    @Column(name = "exercise_id")
    private Exercise exerciseId;
}
