package com;

import com.utils.DBConnector;

public class Main {
    public static void main(String[] args) throws Exception {
        DBConnector dao = new DBConnector();
        dao.readDataBase();
    }

}