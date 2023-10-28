package com.zubayr.MyServer;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "postgres";
        Connection connection = DriverManager.getConnection(url, user, pass);
        Statement statement = connection.createStatement();


//        statement.executeUpdate("create table Skill (id integer , name varchar(20), primary key (id)) ");
//        statement.executeUpdate("insert into Skill values (1, 'java core')");
//        statement.executeUpdate("insert into Skill values (2, 'sql')");
//        statement.executeUpdate("insert into Skill values (3, 'hibernate')");
//
//        statement.executeUpdate("create table Developers (id integer, name varchar(100), primary key (id))");
//        statement.executeUpdate("insert into Developers values(1, 'Соколов В.А') ");
//        statement.executeUpdate("insert into Developers values(2, 'Смирнов Г.В') ");
//        statement.executeUpdate("insert into Developers values(3, 'Сидоров Н.Н') ");

//        statement.executeUpdate("create table Skill_dev (id integer, id_skill integer, id_dev integer, primary key (id), foreign key (id_skill) references Skill (id), foreign key (id_dev) references Developers (id))");
//        statement.executeUpdate("insert into Skill_dev values (1, 1, 2)");
//        statement.executeUpdate("insert into Skill_dev values (2, 1, 3)");
//        statement.executeUpdate("insert into Skill_dev values (3, 2, 1)");
//        statement.executeUpdate("insert into Skill_dev values (4, 3, 1)");
//        statement.executeUpdate("insert into Skill_dev values (5, 3, 2)");
//        statement.executeUpdate("insert into Skill_dev values (6, 3, 3)");


        ResultSet resultSet = statement.executeQuery("select * from Developers");
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }


        statement.cancel();
        connection.close();
    }


}
