package comm.vlad.system.configs;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnectivity {
 static {
     try {
         DriverManager.registerDriver(new Driver());
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }
 public static Connection getConnection(){
     try {
         return DriverManager.getConnection("jdbc:postgresql://localhost:5432/BankDB", "postgres", "28072004");
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }
 public static Statement getStatement(){
     try {
         return getConnection().createStatement();
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }
}
