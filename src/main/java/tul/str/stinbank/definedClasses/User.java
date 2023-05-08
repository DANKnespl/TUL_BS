/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.definedClasses;

/**
 *
 * @author Tommy
 */
public class User {
    String Name;
    String Surname;
    String pass;
    String email;
    Account account;
    String factorKey;

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getPass() {
        return pass;
    }

    public Account getAccount() {
        return account;
    }

    public String getFactorKey() {
        return this.factorKey;
    }

    public void setFactorKey(String factorKey) {
        this.factorKey = factorKey;
    }

    public String getEmail() {
        return email;
    }

    public User(String Name, String Surname, String pass, String email, Account account) {
        this.Name = Name;
        this.Surname = Surname;
        this.pass = pass;
        this.email = email;
        this.account = account;
        this.factorKey = null;
    }

    @Override
    public String toString() {
        return "User{" + "Name=" + Name + ", Surname=" + Surname + ", email=" + email + ", account=" + account + '}';
    }
}
