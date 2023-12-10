/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatamahasiswa.connection;

import java.sql.*;

/**
 *
 * @author admin
 */
public class DbConnection {
    private String driver, url, db, user, pass;
    
    public DbConnection() {
        driver = "com.mysql.cj.jdbc.Driver"; //Default For Connection Driver MySql
        db  = "db_pbo"; //Database Name
        url = "jdbc:mysql://localhost:3306/" + db + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //Hots + DB Name
        user = "root"; //User Databse
        pass = ""; //Password Database
    }
    
    public Connection getConnection() {
        Connection con = null;
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Success connect to DB");
        } catch(ClassNotFoundException er) {
            System.out.println("Error #1: " + er.getMessage());
            System.exit(0);
        } catch (SQLException er) {
            System.out.println("Error #2: " + er.getMessage());
            System.exit(0);
        }
        
        return con;
    }
}
