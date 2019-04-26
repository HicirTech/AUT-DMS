/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

/**
 * A single student object
 * @author Zeting Luo ID:16938158
 */
public class SingleStudent {
    private int studentId;
    private String firstName;
    private String lastName;

    
    SingleStudent(int id, String firstName, String lastName)
    {
        this.studentId = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFullName()
    {
        return this.getFirstName()+" "+this.getLastName();
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String toString(){
        return this.getStudentId()+", "+this.getFirstName()+" "+this.getLastName();
    }
}
