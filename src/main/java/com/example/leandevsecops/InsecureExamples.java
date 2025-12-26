package com.example.leandevsecops;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsecureExamples {

    // SonarCloud should flag hardcoded credentials (e.g., rule like S2068)
    private static final String DB_PASSWORD = "SuperSecret123!"; // demo only
    private static final String API_KEY = "hardcoded-api-key-123"; // demo only

    /**
     * SonarCloud should flag SQL Injection risk:
     * user input is concatenated into the SQL query.
     *
     * NOTE: This method is NOT called anywhere. It's only here to trigger SAST findings.
     */
    public int insecureUserLookup(Connection conn, String userInput) throws SQLException {
        String sql = "SELECT id FROM users WHERE username = '" + userInput + "'"; // vulnerable pattern
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            return rs.next() ? rs.getInt("id") : -1;
        }
    }
}
