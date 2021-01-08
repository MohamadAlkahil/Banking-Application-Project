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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kahil
 */
public class Manager_WindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField Adduser;
    private TextField Addpass;
    private TextField Deluser;
    private TextField state;
    private Manager manager;
    @FXML
    public void LogoutPushed(ActionEvent event)throws IOException{
        Parent FXMLDocumentViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene FXMLDocumentViewscene = new Scene(FXMLDocumentViewParent);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentViewscene);
        window.show();
    }
    @FXML
    public void addPushed(ActionEvent event)throws Exception{
        if (!Adduser.getText().equals("") && !Addpass.getText().equals("")) {
            manager.addCustomer(Adduser.getText(), Addpass.getText(), 100);
            state.setText("valid Entry");
        }
        else{
            state.setText("Invalid Entry");
        }
    }
    @FXML
    public void delePushed(ActionEvent event)throws Exception{
        if (!Deluser.getText().equals("")) {
            manager.deleteCustomer(Deluser.getText());
            state.setText("valid Entry");
        }
        else{
            state.setText("Invalid Entry");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Manager Started!");
    }    
    
}
