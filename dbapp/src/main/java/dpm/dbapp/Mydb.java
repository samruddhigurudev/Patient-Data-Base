/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpm.dbapp;
import java.sql.*;

/**
 *
 * @author sspmcoe
 */
public class Mydb {
    Connection connection;
    PreparedStatement st;
    ResultSet rs1,rs2;
    
    Mydb()
    {
        try {       
             Class.forName("com.mysql.jdbc.Driver");
                    connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/patient",
                        "root", "");
               System.out.println("Connect");
            } catch (Exception e) {
                    System.out.println(e);
                }
            
    }
    public void insert(int patientId,String patientName,String patientAdmitDate,String patientDisease,int patientAge,int patientMobno)
    {
        try {
            st = (PreparedStatement) connection
                        .prepareStatement("INSERT INTO `patientdb`  VALUES ('"+patientId + "', '" + patientName +"', '"+ patientAdmitDate +"', '"+ patientDisease +"', '"+ patientAge +"', '"+ patientMobno +"')");
            String qs ="INSERT INTO `patientdb`  VALUES ('"+patientId + "', '" + patientName +"', '"+ patientAdmitDate +"', '"+ patientDisease +"', '"+ patientAge +"', '"+ patientMobno +"')";
            System.out.println(qs);
            System.out.println(st.execute());
            
            /*if(st.execute())
            {
                System.out.print("Insert");
                //JOptionPane.showMessageDialog(Mydb, "You have successfully inserted");
            } else {
                        //JOptionPane.showMessageDialog(Mydb, "Wrong input");
                        System.out.print("Insert failed");
                    }*/
        }
        catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
    }
    public static void main(String args[])
    {
        Mydb d =new Mydb();
        d.insert(1,"Riya","28-oct-2023","Cancer",45,1234567890);
    }
    
}
