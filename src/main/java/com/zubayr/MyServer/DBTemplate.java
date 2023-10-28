package com.zubayr.MyServer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBTemplate {


    private Connection connection;
    private Statement statement;

    public DBTemplate(){
        final String url = "jdbc:postgresql://localhost:5432/postgres";;
        final String user = "postgres";
        final String pass = "postgres";
        try {
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


//    static {
//        final String url = "jdbc:postgresql://localhost:5432/postgres";;
//        final String user = "postgres";
//        final String pass = "postgres";
//        try {
//            connection = DriverManager.getConnection(url, user, pass);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        try {
//            statement = connection.createStatement();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }


    public void createTable() throws SQLException {
        statement.executeUpdate("create table Skill (id integer, name varchar(20), primary key (id)) ");
        statement.executeUpdate("insert into Skill values (1, 'java core')");
        statement.executeUpdate("insert into Skill values (2, 'sql')");
        statement.executeUpdate("insert into Skill values (3, 'hibernate')");

        statement.executeUpdate("create table Developers (id integer, name varchar(100), primary key (id))");
        statement.executeUpdate("insert into Developers values(1, 'Соколов В.А') ");
        statement.executeUpdate("insert into Developers values(2, 'Смирнов Г.В') ");
        statement.executeUpdate("insert into Developers values(3, 'Сидоров Н.Н') ");

        statement.executeUpdate("create table Skill_dev (id integer, id_skill integer, id_dev integer, primary key (id), foreign key (id_skill) references Skill (id), foreign key (id_dev) references Developers (id))");
        statement.executeUpdate("insert into Skill_dev values (1, 1, 2)");
        statement.executeUpdate("insert into Skill_dev values (2, 1, 3)");
        statement.executeUpdate("insert into Skill_dev values (3, 2, 1)");
        statement.executeUpdate("insert into Skill_dev values (4, 3, 1)");
        statement.executeUpdate("insert into Skill_dev values (5, 3, 2)");
        statement.executeUpdate("insert into Skill_dev values (6, 3, 3)");
    }

    public List<String> getAllDevelopers() throws SQLException {
        ResultSet result = statement.executeQuery("select * from Developers");
        List<String> developers = new ArrayList<>();
        while (result.next()){
            developers.add(result.getString("name"));
        }
        return developers;
    }

    public void add(String name) {
        try {
            ResultSet resultSet = statement.executeQuery("select count(*) from developers");
            int id = 0;
            if (resultSet.next()) id = resultSet.getInt(1);
            String execute = String.format("insert into developers VALUES(%1s, '%2s')",++id, name);
            statement.executeUpdate(execute);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Integer id) {
        System.out.println(id);
        try {
            statement.executeUpdate("delete from Developrers where id =" + id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }









}
