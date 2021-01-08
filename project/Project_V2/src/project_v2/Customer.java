/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_v2;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author kahil
 */
public class Customer extends Actor {
     /**
     * Overview: Manages the Customer files, by adding and deleting them
     *  AF(c) = An Actor is a Customer,c such that:
     * c.level= "Silver" || "Gold" || "Platinum"
     * RI(c) = 
     * c.username!=""
     * c.username!=""
     */
    

    private double balance;
    private Levels level;
    
    /**
     * Requires:A unique username
     * 
     * EFFECTS: Creates the Customer
     * 
     */
    public Customer(String u,String p,String r) throws Exception{
        super(u,p,r);
    }
    
    /**
     * 
     * EFFECTS: sets Levels
     * 
     */
    public void setlevel(Levels l){
        level =l;
    }
    /**
     * 
     * EFFECTS: changes the levels if necessary
     * 
     */
    public void changeLevels(){
        level.changeLevels(this);
    }
    /**
     * 
     * EFFECTS: returns Level
     * 
     */
    public Levels getlevel(){
        return level;
    }
    
    /**
     * Requires:A a none zero or negative input
     * 
     * EFFECTS: Adds input to balance
     * 
     */
    public void deposit(double a)throws Exception{
        if(a<=0){
            throw new IllegalArgumentException("A zero or negative amount cannot be deposited");
        }
        balance+=a;
        changeLevels();
        changebalance();
        System.out.println(toString());
    }
    
    /**
     * Requires:A a none zero or negative input, and enough money in the balance
     * 
     * EFFECTS: subtracts input from balance
     * 
     */
     public void withdraw(double a)throws Exception{
        if(a<=0){
            throw new IllegalArgumentException("A zero or negative amount cannot be withdrawn");
        }
        if(a>getbalance()){
            throw new IllegalArgumentException("There is not enough funds to make this Transaction");
        }
        balance-=a;
        changeLevels();
        changebalance();
        System.out.println(toString());
    }
     /**
     * 
     * EFFECTS: returns balance
     * 
     */
    public double  getbalance(){
        return balance;
    } 
    /**
     * Requires:A a none zero or negative input, enough money in the balance, and the inpt to be greater than $50
     * 
     * EFFECTS: subtracts input from balance
     * 
     */
    public void OnlinePurchace(double a)throws Exception{
        if(a<=0){
            throw new IllegalArgumentException("A zero or negative amount cannot be purchased");
        }
        if((a+level.fee())>getbalance()){
            throw new IllegalArgumentException("There is not enough funds to make this Transaction");
        }
        if(a<50){
            throw new IllegalArgumentException("A purchase cannot be made for less than $50");
        }
        balance=balance-(a+level.fee());
        changeLevels();
        changebalance();
        System.out.println(toString());
    }
    
    /**
     * 
     * EFFECTS: stores new balance info to customer files
     * 
     */
    public void changebalance(){
        try {
          FileWriter CustomerFile = new FileWriter(getusername()+".txt");
          PrintWriter CustomerPrinter= new PrintWriter(CustomerFile);
          CustomerPrinter.println(getrole());
          CustomerPrinter.println(getusername());
          CustomerPrinter.println(getpassword());
          CustomerPrinter.println(getbalance());
          CustomerPrinter.close();
          System.out.println("File for: "+getusername()+" updated");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
    @Override
    public String toString(){
      return ("Account Balance"+getbalance()+super.toString()+" Level:"+getlevel().lev());
   }
    
}
