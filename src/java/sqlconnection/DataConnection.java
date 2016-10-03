/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vithu
 */

public class DataConnection {
    Connection conn;
    
 static public   Connection  getDataConnection()
    {
          
                  String url = "jdbc:mysql://localhost:3306/";
		  String dbName = "presenza";
		  String driver = "com.mysql.jdbc.Driver";
		  String userName = "root"; 
		  String password = "";    
        try {
            Class.forName(driver).newInstance();
               Connection conn = DriverManager.getConnection(url+dbName,userName,password);
                return conn;
                
                
        } catch (Exception ex) {
            //Logger.getLogger(DataConection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
                 
    
    
    
        

    
    
    

