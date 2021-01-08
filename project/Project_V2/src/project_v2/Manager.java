/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_v2;

/**
 *
 * @author kahil
 */
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Manager extends Actor {

    private ArrayList items= new ArrayList();
   
    public Manager(String u,String p,String r)throws Exception{
        super(u,p,r);
    }
   
   public void addCustomer(String u,String p,double b) throws Exception{
       try {
        FileWriter CustomerFile = new FileWriter(u+".txt");
        PrintWriter CustomerPrinter= new PrintWriter(CustomerFile);
        if(items.contains(u)){
          System.out.println("File already exists.");  
        }
        else{
          CustomerPrinter.println(u);
          CustomerPrinter.println(p);
          CustomerPrinter.println(b);
          CustomerPrinter.close();
          items.add(u);
          System.out.println("Added File for: "+u);
        }
      }catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
   }
   
   public void deleteCustomer(String u)throws Exception{
       if(items.contains(u)){
           items.remove(u);
           File CustomerFile= new File(u+".txt");
           CustomerFile.delete();
           System.out.println("File for: "+u+" is deleted.");
       }
       else{
          System.out.println("File does not exist."); 
       }    
   }
    
   public boolean itemscontains(String u){
       if(items.contains(u)){
           return true;
       }
       return false;
   }
    
    @Override
    public String toString(){
      return (super.toString());
   }
}
