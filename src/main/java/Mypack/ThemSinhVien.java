package Mypack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ThemSinhVien {

     Connection connection = null;
     PreparedStatement preparedStatement = null;
     Scanner sc = new Scanner(System.in);
     public void insertStudent(){
       DBConnection kn = new DBConnection();
       connection = kn.ketNoi();
       String username;
       int mssv;
       System.out.println("Moi ban nhap username: ");
       username = sc.nextLine();
       System.out.println("Moi ban nhap mssv: ");
       mssv = sc.nextInt();

       String sql = "insert into student(username,mssv) values(?,?)";
       try {
         preparedStatement = connection.prepareStatement(sql);
         preparedStatement.setString(1,username);
         preparedStatement.setInt(2,mssv);
         int kt = preparedStatement.executeUpdate();
         if(kt !=0){
           System.out.println("Nhap du lieu thanh cong");
         }else {
           System.out.println("Nhap du lieu khong thanh cong");
         }
         preparedStatement.close();
         connection.close();
       } catch (SQLException e) {
         System.out.println(e.getMessage());
       }
     }
}
