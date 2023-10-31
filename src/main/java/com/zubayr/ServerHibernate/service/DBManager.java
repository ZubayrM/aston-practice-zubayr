package com.zubayr.ServerHibernate.service;

import com.zubayr.ServerHibernate.dao.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Properties;

public class DBManager {

    private SessionFactory sessionFactory;

    public DBManager(){
        Properties properties = new Properties();
        properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        properties.put("hibernate.connection.username", "postgres");
        properties.put("hibernate.connection.password", "postgres");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");


        StandardServiceRegistry registryBuilder = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadataBuilder = new MetadataSources(registryBuilder).getMetadataBuilder().build();
        sessionFactory = metadataBuilder.getSessionFactoryBuilder().build();
    }

    private Session getSession(){
        return sessionFactory.openSession();
    }


    public void addEmployee(int count){
        Session session = getSession();

        Department department = new Department();
        department.setName("OGK");
        session.persist(department);

        for (int i = 0; i < count; i++) {
            Employee employee;
            if (i % 2 == 0) employee = new Constructor();
            else employee = new Technologist();

            employee.setName(String.format("Name-%d", i));

            if (employee instanceof Constructor) ((Constructor) employee).setDepartment(session.get(Department.class, 1));
            else ((Technologist) employee).setCategory("3");

            session.persist(employee);
        }
    }



}
