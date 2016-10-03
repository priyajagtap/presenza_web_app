/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web_services;

import Pogo_Classes.Attendance_Data;
import Pogo_Classes.SignUp_Data;
import com.google.gson.Gson;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import sqlconnection.DataConnection;

/**
 *
 * @author infogird31
 */
@WebService(serviceName = "Signup_webservice")
public class Signup_webservice {

    /**
     * This is a sample web service operation
     */
    /*
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
*/
    /**
     * Web service operation
     */
    @WebMethod(operationName = "Signup")
    public String Signup(@WebParam(name = "teacher_uid") 
            String teacher_uid, @WebParam(name = "teacher_name") 
            String teacher_name, @WebParam(name = "teacher_dept") 
            String teacher_dept, @WebParam(name = "teacher_post") 
            String teacher_post, @WebParam(name = "teacher_pwd") 
            String teacher_pwd) {
        //TODO write your implementation code here:
         //TODO write your implementation code here:
        Gson ob = new Gson();
        Type t1 = new TypeToken<ArrayList<SignUp_Data>>(){}.getType();
       // List<SignUp_Data> ar = ob.fromJson(s,t1);
      //  for(SignUp_Data st:ar){
            Connection connection;
            Statement statement = null;
            ResultSet resultSet = null;
            ResultSetMetaData metaData = null;
            int numberOfColumns = 0;
            try{
                connection = DataConnection.getDataConnection();
                statement = connection.createStatement();
               // INSERT INTO `teacher_details`(`teacher_id`, `teacher_name`, `teacher_post`, `dept`, `pass`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5])
                String insertQuery = "INSERT INTO teacher_details(teacher_id,teacher_name,teacher_post,dept,pass) VALUES(?,?,?,?,?)";
                PreparedStatement pstmt = null;
                pstmt = connection.prepareStatement(insertQuery);
                pstmt.setString(1,teacher_uid);
                pstmt.setString(2,teacher_name);
                pstmt.setString(3,teacher_post);
                pstmt.setString(4,teacher_dept);
                pstmt.setString(5,teacher_pwd);
                int rowcount = pstmt.executeUpdate();
                return "1";
            }
            catch(SQLException e)
            {
                e.getMessage();
                return "exception" + e;
            }          
   }
    
    /**
     * Web service operation
     */
    /*
    @WebMethod(operationName = "Register")
    public String Register(@WebParam(name = "s") String s) {
        //TODO write your implementation code here:
        Gson ob = new Gson();
        Type t1 = new TypeToken<ArrayList<SignUp_Data>>(){}.getType();
        List<SignUp_Data> ar = ob.fromJson(s,t1);
        for(SignUp_Data st:ar){
            Connection connection;
            Statement statement = null;
            ResultSet resultSet = null;
            ResultSetMetaData metaData = null;
            int numberOfColumns = 0;
            try{
                connection = DataConnection.getDataConnection();
                statement = connection.createStatement();
               // INSERT INTO `teacher_details`(`teacher_id`, `teacher_name`, `teacher_post`, `dept`, `pass`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5])
                String insertQuery = "INSERT INTO teacher_details(teacher_id,teacher_name,teacher_post,dept,pass) VALUES(?,?,?,?,?)";
                PreparedStatement pstmt = null;
                pstmt = connection.prepareStatement(insertQuery);
                pstmt.setString(1,st.getTeacher_id());
                pstmt.setString(2, st.getTeacher_name());
                pstmt.setString(3, st.getTeacher_post());
                pstmt.setString(4,st.getDept());
                pstmt.setString(5,st.getPass());
                int rowcount = pstmt.executeUpdate();
                return "Registration Successful..!";
            }
            catch(  SQLException e)
            {
                e.getMessage();
                return "exception" + e;
            }    
        } 
       return "end";
 }
    */
    /**
     * Web service operation
     */
@WebMethod(operationName = "LoginOperation")
public String LoginOperation(@WebParam(name = "UID") String UID,@WebParam(name = "PWD") String PWD) 
{
        //TODO write your implementation code here:
        Connection connection;
        Statement statement = null;
        ResultSet resultSet = null;
        int numberOfColumns = 0;
        try
        {      
            connection = DataConnection.getDataConnection();
            statement = connection.createStatement();
            String a="SELECT teacher_id,pass FROM teacher_details WHERE teacher_id ='"+UID+"' AND pass='"+PWD+"'";
            resultSet = statement.executeQuery(a);
            int check = 0;
            if(!resultSet.isBeforeFirst())
            {
                check = 0;
            }
            else
            {
                check = 1;
            }
            return ""+check;
        }
        catch(  SQLException e)
        {
            e.getMessage();
            return "exception" + e;
        }  
  }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Add_Student_Operation")
    public String Add_Student_Operation(
            @WebParam(name = "st_uid") String st_uid,
            @WebParam(name = "st_name")String st_name, 
            @WebParam(name = "st_rollno")String st_rollno,
            @WebParam(name = "st_branch")String st_branch,
            @WebParam(name = "st_study_year")String st_study_year,
            @WebParam(name = "st_aca_year") String st_aca_year,
            @WebParam(name = "st_div")String st_div,
            @WebParam(name = "st_pract_batch") String st_pract_batch) {

        Gson ob = new Gson();
        Type t1 = new TypeToken<ArrayList<SignUp_Data>>(){}.getType();

            Connection connection;
            Statement statement = null;
            ResultSet resultSet = null;
            ResultSetMetaData metaData = null;
            int numberOfColumns = 0;
            try{
                connection = DataConnection.getDataConnection();
                statement = connection.createStatement();
        //    INSERT INTO `student_details`(`unique_id`, `stud_name`, `roll_no`, `branch`, `class_year`, `academic_year`, `division`, `pract_batch`)
                String insertQuery = "INSERT INTO student_details(unique_id,stud_name,roll_no,branch,class_year,academic_year,division,pract_batch) VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement pstmt = null;
                pstmt = connection.prepareStatement(insertQuery);
                pstmt.setString(1,st_uid);
                pstmt.setString(2,st_name);
                pstmt.setString(3,st_rollno);
                pstmt.setString(4,st_branch);
                pstmt.setString(5,st_study_year);
                pstmt.setString(6,st_aca_year);
                pstmt.setString(7,st_div);
                pstmt.setString(8,st_pract_batch);
                int rowcount = pstmt.executeUpdate();
                return "1";
            }
            catch(SQLException e)
            {
                e.getMessage();
                return "exception" + e;
            }     
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Add_Subject_Operation")
    public String Add_Subject_Operation(
            @WebParam(name = "Sub_Name") String Sub_Name
            , @WebParam(name = "Teacher_Uid") String Teacher_Uid
            , @WebParam(name = "Sub_Type") String Sub_Type
            , @WebParam(name = "Sub_Batch") String Sub_Batch
            , @WebParam(name = "Sub_Class") int Sub_Class) {
        //TODO write your implementation code here:
        //  Gson ob = new Gson();
      //  Type t1 = new TypeToken<ArrayList<SignUp_Data>>(){}.getType();

            Connection connection;
            Statement statement = null;
            ResultSet resultSet = null;
            ResultSetMetaData metaData = null;
            int numberOfColumns = 0;
            try{
                connection = DataConnection.getDataConnection();
                statement = connection.createStatement();
      // INSERT INTO `subject_details`(`Sub_Name`, `Teacher_Uid`, `Sub_Type`, `Sub_Batch`, `Sub_Class`)
                String insertQuery = "INSERT INTO subject_details(Sub_Name,Teacher_Uid,Sub_Type,Sub_Batch,Sub_Class) VALUES(?,?,?,?,?)";
                PreparedStatement pstmt = null;
                pstmt = connection.prepareStatement(insertQuery);
                pstmt.setString(1,Sub_Name);
                pstmt.setString(2,Teacher_Uid);
                pstmt.setString(3,Sub_Type);
                pstmt.setString(4,Sub_Batch);
                pstmt.setInt(5,Sub_Class);
               
                int rowcount = pstmt.executeUpdate();
                return "1";
            }
            catch(SQLException e)
            {
                e.getMessage();
                return "exception" + e;
            }     
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Take_Attendance_Operation")
    public String Take_Attendance_Operation(
            @WebParam(name = "Stud_ID") String Stud_ID
            , @WebParam(name = "Sub_Class") int Sub_Class
            , @WebParam(name = "Sub_Name") String Sub_Name
            , @WebParam(name = "Date") String Date
            , @WebParam(name = "Time") String Time
            , @WebParam(name = "Attendence") String Attendence
            , @WebParam(name = "Stud_Name") String Stud_Name
            , @WebParam(name = "Stud_Roll_No") String Stud_Roll_No) {
        //TODO write your implementation code here:
       Connection connection;
            Statement statement = null;
            ResultSet resultSet = null;
            ResultSetMetaData metaData = null;
            int numberOfColumns = 0;
            try{
                connection = DataConnection.getDataConnection();
                statement = connection.createStatement();
      // INSERT INTO `Attendance_Details`(`Stud_ID`, `Sub_Class`, `Sub_Name`, `Date`, `Time`, `Attendence`, `Stud_Name`, `Stud_Roll_No`)
                String insertQuery = "INSERT INTO Attendance_Details(Stud_ID,Sub_Class,Sub_Name,Date,Time,Attendence,Stud_Name,Stud_Roll_No) VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement pstmt = null;
                pstmt = connection.prepareStatement(insertQuery);
                pstmt.setString(1,Stud_ID);
                pstmt.setInt(2,Sub_Class);
                pstmt.setString(3,Sub_Name);
                pstmt.setString(4,Date);
                pstmt.setString(5,Time);
                pstmt.setString(6,Attendence);
                pstmt.setString(7,Stud_Name);
                pstmt.setString(8,Stud_Roll_No);            
               
                int rowcount = pstmt.executeUpdate();
                return "1";
            }
            catch(SQLException e)
            {
                e.getMessage();
                return "exception" + e;
            }     
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Insert_Attendance")
    public String Insert_Attendance(@WebParam(name = "s") String s) {
        //TODO write your implementation code here:
      
        System.out.println("got data from android" + s);
        
        Gson ob = new Gson();
        Type t1 = new TypeToken<ArrayList<Attendance_Data>>(){}.getType();
        
       List<Attendance_Data> ar = ob.fromJson(s,t1);
       for(Attendance_Data st:ar){ 
            System.out.println("data to insert" + st);
            Connection connection;
            Statement statement = null;
            ResultSet resultSet = null;
            ResultSetMetaData metaData = null;

            int numberOfColumns = 0;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/presenza" ,"root","");
            statement = connection.createStatement();
            System.out.println("Connection Established");
            System.out.println("\ninsert into Attendance_Details Table");
            
            String insertQuery = "INSERT INTO Attendance_Details(Stud_ID,Sub_Class,Sub_Name,Date,Time,Attendence,Stud_Name,Stud_Roll_No) VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement pstmt = null;
            pstmt = connection.prepareStatement(insertQuery);

                pstmt.setString(1,st.getStud_ID());
                pstmt.setInt(2,st.getSub_Class());
                pstmt.setString(3,st.getSub_Name());
                pstmt.setString(4,st.getDate());
                pstmt.setString(5,st.getTime());
                pstmt.setString(6,st.getAttendence());
                pstmt.setString(7,st.getStud_Name());
                pstmt.setString(8,st.getStud_Roll_No());    

                int rowcount = pstmt.executeUpdate();

                return "1";
            }
            catch(  ClassNotFoundException | SQLException e)
            {
            e.getMessage();
            return "exception" + e;
            } 
        } 
       return "end";
    }
}
