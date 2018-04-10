package Mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

  public Connection ketNoi() {

    Connection connection = null;
    String url = "jdbc:mysql://localhost:3306/quanlysinhvien";
    String username = "root";
    String password = "1234";
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(url, username, password);
//      if(connection != null){
//        System.out.println("Ket noi thanh cong");
//      }
    } catch (ClassNotFoundException e) {
      System.out.println("load driver khong thanh cong");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return connection;
  }
}
