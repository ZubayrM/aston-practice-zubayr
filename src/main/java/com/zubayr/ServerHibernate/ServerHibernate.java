package com.zubayr.ServerHibernate;

import com.zubayr.ServerHibernate.service.DBManager;

public class ServerHibernate {
    public static void main(String[] args) {
        DBManager manager = new DBManager();

        manager.addEmployee(10);
    }
}
