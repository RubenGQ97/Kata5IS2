/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ruben Garcia Quintana
 */ 
public class Kata5P1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\senyo\\Documents\\NetBeansProjects\\Kata5P1\\Nueva carpeta\\DB.db");

        Statement st = con.createStatement();

        
        
        
        
        String q = "SELECT * FROM PEOPLE";
        ResultSet results = st.executeQuery(q);

        while(results.next()){
            System.out.println(results.getInt(1));
            System.out.println(results.getString(2));
        }

    }

}