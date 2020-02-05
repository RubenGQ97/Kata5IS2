/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        // TODO code application logic here
        FileReader fl;
        BufferedReader bf;
        
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\senyo\\Documents\\NetBeansProjects\\Kata5P1\\Nueva carpeta\\DB.db");

        Statement st = con.createStatement();

        
        String q2 = "CREATE TABLE IF NOT EXISTS MAIL ('Id' INTEGER PRIMARY KEY AUTOINCREMENT , 'Mail' TEXT NOT NULL);";
        st.execute(q2);
        
        
        
        
        
        
        String fileName = "C:\\Users\\senyo\\Documents\\NetBeansProjects\\Kata5P1\\email.txt";

        try{
            fl = new FileReader(fileName);
            bf = new BufferedReader(fl);
            String mail;
            while((mail = bf.readLine()) != null){
                if(!mail.contains("@")){
                    continue;
                }
                q2 =	"INSERT	INTO	MAIL	(Mail)	VALUES	('"+ mail +"');”";	
                st.execute(q2);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        String q1 = "SELECT COUNT(*) FROM MAIL";
        ResultSet result = st.executeQuery(q1);
        System.out.println("Número de registros de la tabla MAIL: " + result.getInt(1));


    }

}