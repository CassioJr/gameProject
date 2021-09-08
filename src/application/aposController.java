package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class aposController {
    @FXML
    private Label experienciaGanha;
    @FXML
    private Label ouroGanho;
    private Stage primaryStage;
    
    public void colocaValores(int ouro, int experiencia) {
    	ouroGanho.setText(String.valueOf(ouro));
    	experienciaGanha.setText(String.valueOf(experiencia));
    }
    
    public void chamaTela(ActionEvent event) throws IOException {
    	AnchorPane fxmlmenu = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaEspera.fxml"));
		Scene main = new Scene(fxmlmenu);
		primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(main);
    }
}
