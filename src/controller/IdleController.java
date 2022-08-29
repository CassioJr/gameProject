package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import event.MapEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.entity.Enemy;
import model.entity.Player;
import util.FileManagement;
import util.Messages;

public class IdleController implements Initializable {
	private Stage primaryStage;
	@FXML
	private Label namePlayer, levelPlayer, goldPlayer;
	@FXML
	private AnchorPane screenAboutHistory;
	private Player p = FileManagement.loadPlayerData();

	public void setPlayerInformation() {
		try {
			namePlayer.setText(FileManagement.loadPlayerData().getName());
			levelPlayer.setText(String.valueOf(FileManagement.loadPlayerData().getLevel()));
			goldPlayer.setText(String.valueOf(FileManagement.loadPlayerData().getMoney()));
		} catch (Exception e) {
			Messages.MSG("Save Corrompido");
			System.out.println(e);
		}
	}

	public void btnSobreHistoria() {
		if (!screenAboutHistory.isVisible()) {
			screenAboutHistory.setVisible(true);
		} else {
			screenAboutHistory.setVisible(false);
		}
	}

	public void btnActionEvents(ActionEvent event, Enemy m) {
		try {
			FXMLLoader fxmlcombate = new FXMLLoader(getClass().getResource("/view/View_Combat.fxml"));
			Parent root = fxmlcombate.load();

			CombatController combate = fxmlcombate.getController();
			combate.enemySetInfo(m);

			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (IOException e) {
			System.err.println("Houve um erro ao carregar!");
		}
	}

	public void btnSeaCreature(ActionEvent event) {
		btnActionEvents(event, MapEvent.seaCreatureEvent(p));
	}

	public void btnReign(ActionEvent event) {
		btnActionEvents(event, MapEvent.reignEvent());
	}

	public void btnDragon(ActionEvent event) {
		btnActionEvents(event, MapEvent.dragonEvent());
	}

	public void btnDragonBoss(ActionEvent event) {
		btnActionEvents(event, MapEvent.dragonEventBoss());
	}

	public void btnCatedral(ActionEvent event) {
		btnActionEvents(event, MapEvent.catedralEvent());
	}

	public void btnWinterVillage(ActionEvent event) {
		btnActionEvents(event, MapEvent.winterVillageEvent());
	}

	public void btnBattleAcampament(ActionEvent event) {
		btnActionEvents(event, MapEvent.battleAcampamentEvent());
	}

	public void btnOrcVillage(ActionEvent event) {
		btnActionEvents(event, MapEvent.orcVillageEvent());
	}

	public void btnFort(ActionEvent event) throws IOException {
		btnActionEvents(event, MapEvent.fortEvent(p));
	}

	public void btnMenu(ActionEvent event) throws IOException {
		if (Messages.MSGEscolha("Deseja voltar ao menu?") == true) {
			changeScene(event, "View_Menu");
		}
	}

	public void btnExplorar(ActionEvent event) throws IOException {
		FXMLLoader fxmlcombate = new FXMLLoader(getClass().getResource("/view/View_Combat.fxml"));
		Parent root = fxmlcombate.load();

		CombatController combate = fxmlcombate.getController();
		combate.beginCombat();

		primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public void changeScene(ActionEvent event, String tela) {
		try {
			Parent fxml = FXMLLoader.load(getClass().getResource("/view/" + tela + ".fxml"));
			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(new Scene(fxml));
			primaryStage.show();
		} catch (IOException e) {
			System.out.println("Erro ao carregar a tela!");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		FileManagement.readSpellFile();
		setPlayerInformation();
	}
}
