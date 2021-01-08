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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kahil
 */
public class Customer_WindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public void LogoutPushed(ActionEvent event)throws IOException{
        Parent FXMLDocumentViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene FXMLDocumentViewscene = new Scene(FXMLDocumentViewParent);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentViewscene);
        window.show();
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Customer Started!");
    }    
    
}
