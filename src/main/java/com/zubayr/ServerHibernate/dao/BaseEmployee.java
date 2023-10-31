package com.zubayr.ServerHibernate.dao;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseEmployee {

    @Id
    @SequenceGenerator(name = "myTechnology", sequenceName = "myTechnology", initialValue = 1, allocationSize = 16)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myTechnology")
    private Integer id;
}
