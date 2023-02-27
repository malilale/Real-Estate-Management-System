/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assets;

/**
 *
 * @author Muhammed Ali LALE
 */
public class User {
    public String userName;
    public String firstName;
    public String lastName;
    public String tel;
    public int salary;

    public User() {
    }
    
    public User(String userName, String firstName, String lastName, String tel, int salary) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.salary = salary;
    }
}
