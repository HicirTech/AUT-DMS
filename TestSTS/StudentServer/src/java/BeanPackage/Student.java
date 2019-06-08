/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPackage;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MY PHU NGUYEN
 */

/**
 *
 * @author MY PHU NGUYEN
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Student {
    private static int studentNumber=0;
    private int studentID;
    private String studentName;
    private int age;
    private Gender gender;
    private String password;
    
    public Student ()
    {
        super();
    }
    
    public Student(int studentID, String studentName, int age, Gender gender, String password)
    {
        this.studentID= studentID;
        if (studentID>studentNumber)
        {
            studentNumber= studentID;
        }
        this.studentName= studentName;
        this.age=age;
        this.gender=gender;
        this.password=password;
    }
    
    public Student (String studentName, int age, Gender gender)
    {
        this.studentName= studentName;
        this.age=age;
        this.gender=gender;
        studentNumber++;
        this.studentID=studentNumber;
        this.password="123";
    }
    
    //getter and setter
    public static int getStudentNumber() {
        return studentNumber;
    }
    
    public static void setStudentNumber(int studentNumber) {
        Student.studentNumber = studentNumber;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public int getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", studentName=" + studentName + ", age=" + age + ", gender=" + gender + ", password=" + password + '}';
    }
    
    
    
}

