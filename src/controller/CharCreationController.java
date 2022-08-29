package controller;

import java.io.File;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.entity.Player;
import model.entity.Speciality;
import model.validation.FileValidation;
import util.FileManagement;
import util.Messages;
import util.SpecialityArray;

public class CharCreationController implements Initializable {
	@FXML
	private TextField fieldName;

	@FXML
	private ImageView classImage;

	@FXML
	private ChoiceBox<String> classChoose;

	public void classInfo() {
		SpecialityArray sa = SpecialityArray.getInstance();
		File file = new File(sa.specialityLoad(classChoose.getValue().toString()).getImage());
		Image image = new Image(file.toURI().toString());
		classImage.setImage(image);
	}

	public boolean validacaoCampos() {
		if (fieldName.getText().isEmpty()) {
			Messages.MSG("Você deve preencher o campo de nome ");
			return true;
		} else if (classChoose.getValue() == null) {
			Messages.MSG("Você deve escolher uma classe");
			return true;
		}
		return false;
	}

	public void loadClassesChooseButton() {
		for (Speciality usr : FileManagement.readSpecialityFile().getClasses()) {
			classChoose.getItems().addAll(usr.getName());
		}
	}

	public void iniciar(ActionEvent event) throws IOException {
		SpecialityArray sp = SpecialityArray.getInstance();
		try {
			if (validacaoCampos() == false) {
				if (FileValidation.existSaveFile() == true) {
					if (Messages.MSGEscolha("Já existe um save, deseja criar um novo?") == true) {
						Player jogador = new Player(fieldName.getText(), sp.specialityLoad(classChoose.getValue()));
						FileManagement.savePlayerData(jogador);
						changeScene(event, "View_Idle");
					}
				} else {
					Player jogador = new Player(fieldName.getText(), sp.specialityLoad(classChoose.getValue()));
					FileManagement.savePlayerData(jogador);
					changeScene(event, "View_Idle");
				}
			}
		} catch (Exception e) {
			Messages.MSG("Erro ao tentar criar um novo jogo!");
		}
	}

	public void voltar(ActionEvent event) throws IOException {
		changeScene(event, "View_Menu");
	}

	public void changeScene(ActionEvent event, String tela) {
		try {
			Parent fxml = FXMLLoader.load(getClass().getResource("/view/" + tela + ".fxml"));
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(new Scene(fxml));
			primaryStage.show();
		} catch (IOException e) {
			System.err.println("Erro ao carregar a tela!");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadClassesChooseButton();
	}

}
