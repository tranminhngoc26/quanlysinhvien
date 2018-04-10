package Mypack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hienthithongtin {
   Connection connection = null;
   PreparedStatement preparedStatement = null;
   DBConnection kn = new DBConnection();
   public  void Display(){
     connection = kn.ketNoi();

     String sql = "select * from student";
     try {
       preparedStatement = connection.prepareStatement(sql);
       ResultSet resultSet = preparedStatement.executeQuery();


       System.out.println("studentid    ||    username     ||   mssv");
       while (resultSet.next()){
         int studentid = resultSet.getInt(1);
         String username = resultSet.getString(2);
         int mssv = resultSet.getInt(3);
         System.out.println(studentid+"   "+username+"     "+mssv);
         preparedStatement.close();
         connection.close();
       }
     } catch (SQLException e) {
       System.out.println(e.getMessage());
     }

   }

}
