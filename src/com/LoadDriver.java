package com;

public class LoadDriver {
    public static void load() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {}
    }
}