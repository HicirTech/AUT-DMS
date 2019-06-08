/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPackage;

import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author MY PHU NGUYEN
 */
@Stateless
public class StudentBean {
    private ArrayList<Student> studentList;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public StudentBean()
    {
        studentList= new ArrayList<Student>();
    }
    
    public StudentBean(ArrayList<Student> studentList)
    {
        this.studentList= studentList;
    }
    
    public Student createStudent(String name)
    {
        Student aStudent = new Student(name,18, Gender.Male);
        return aStudent;
    }
    
    public int plusStudent(String name)
    {
        Student aStudent = new Student(name,18, Gender.Male);
        studentList.add(aStudent);
        return studentList.size();
    }
    
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}
