package com.example.AIPictureWorldProject;

import java.sql.Connection;
import java.sql.DriverManager;


public class MariaDBConnetor {

    public void connectionDB() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3307",
                    "ss",
                    "ss"

            );
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
