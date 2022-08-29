package controller;

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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.validation.FileValidation;
import util.MusicManager;

public class MenuController implements Initializable {
	@FXML private Button cont;
	private MusicManager mm = MusicManager.getInstance();

	public void newGame(ActionEvent event){
		changeScene(event, "View_CharCreation");
	}

	public void continueGame(ActionEvent event) {
		changeScene(event, "View_Idle");
	}

	public void exit() {
		System.exit(0);
	}

	public void playMusic() {
		//mm.MusicBackground("Music1");
	}

	public void changeScene(ActionEvent event, String tela) {
		try {
			Parent fxml = FXMLLoader.load(getClass().getResource("/view/" + tela + ".fxml"));
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(new Scene(fxml));
			primaryStage.show();
		} catch (IOException e) {
			System.err.println("Erro ao carregar a tela!" + e);
		}
	}

	public void existSaveFile() {
		if (FileValidation.existSaveToContinue() == true)
			cont.setVisible(true);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		playMusic();
		existSaveFile();
		FileValidation.saveDirectoryExists();
	}
}
