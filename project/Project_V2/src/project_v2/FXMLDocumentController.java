/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_v2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author kahil
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField Adduser;
    private TextField Addpass;
    private TextField state;
    private Label label;
    private Button button1,button11;
    private Manager manager;
    
    @FXML
    public void LoginManagerPushed(ActionEvent event)throws IOException{
        //if(Adduser.getText().equals("admin") && Addpass.getText().equals("admin")){
            Parent Manager_WindowViewParent = FXMLLoader.load(getClass().getResource("Manager_Window.fxml"));
            Scene Manager_WindowViewscene = new Scene(Manager_WindowViewParent);
            Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(Manager_WindowViewscene);
            window.show();   
        //}
        //else{
          //  state.setText("Invalid Entry");
        //}
        
    }
    @FXML
    public void LoginCustomerPushed(ActionEvent event)throws IOException{
        //if(manager.itemscontains(Addpass.getText())){
            Parent Customer_WindowViewParent = FXMLLoader.load(getClass().getResource("Customer_Window.fxml"));
            Scene Customer_WindowViewscene = new Scene(Customer_WindowViewParent);
            Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(Customer_WindowViewscene);
            window.show();
        //}  
        //else{
          //  state.setText("Invalid Entry");
        //}
    }
    
    @FXML
    private void handleButtonClick(ActionEvent event) {
        System.out.println("Stop clicking me!");
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("The Start!");
    }    
    
}
