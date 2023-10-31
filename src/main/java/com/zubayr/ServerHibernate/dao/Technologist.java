package com.zubayr.ServerHibernate.dao;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("technologist")
@Data
@Entity
public class Technologist extends Employee{


    private String category;
}
