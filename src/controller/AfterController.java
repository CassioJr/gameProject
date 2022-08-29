package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.entity.Enemy;
import util.FileManagement;
import util.Operations;

public class AfterController {
    @FXML
    private Label expEarn;
    @FXML
    private Label coinEarn;
    
    public void insertValuesIntoView(Enemy m) {
    	expEarn.setText(String.valueOf(m.getReward()));
    	coinEarn.setText(String.valueOf(m.getXpReward()));
    }
    
    public void changeScreen(ActionEvent event) throws IOException, ClassNotFoundException {
    Parent fxml = FXMLLoader.load(getClass().getResource("/view/View_Idle.fxml"));
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Operations.resetPlayerAttributes(FileManagement.loadPlayerData());
    primaryStage.setScene(new Scene(fxml));
		primaryStage.show();
    }
}
