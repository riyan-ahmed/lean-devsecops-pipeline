package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsecureQuery {
    public ResultSet findUser(Connection conn, String username) throws Exception {
        Statement stmt = conn.createStatement();
        // Vulnerable: concatenating user input directly into SQL
        return stmt.executeQuery("SELECT * FROM users WHERE name = '" + username + "'");
    }
}