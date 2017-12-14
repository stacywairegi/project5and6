package ics1202;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.awt.Event.INSERT;
import java.sql.*;
import java.sql.SQLException;
/**
 *
 * @author STACY
 */
public class CrudeOperations {
    private int student_no;
    private String first_name;
    private String last_name;
    private String gender;
    private String programme;

    /**
     * @return the student_no
     */
    public int getStudent_no() {
        return student_no;
    }

    /**
     * @param student_no the student_no to set
     */
    public void setStudent_no(int student_no) {
        this.student_no = student_no;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the programme
     */
    public String getProgramme() {
        return programme;
    }

    /**
     * @param programme the programme to set
     */
    public void setProgramme(String programme) {
        this.programme = programme;
    }
    
    public int processGel(String g){
       if (g.equalsIgnoreCase("male")){
           return 1;
       }
       return 0;
    }
    public boolean save(){
        PreparedStatement pst = null;
        Connection conn = new DBConnector().con;
        try{
                pst = conn.prepareStatement("INSERT INTO student_details(student_no,first_name,last_name,gender,programme)VALUES(?,?,?,?,?)");
        
             pst.setInt(1, getStudent_no());
             pst.setString(2, getFirst_name());
             pst.setString(3, getLast_name());
             pst.setInt(4, processGel(getGender()));
             pst.setString(5, getProgramme());
             pst.executeUpdate();
             return true;
             
         }catch(SQLException ex){
             System.out.println("Error" + ex.getMessage());
             return false;
         }
    }
    
}
