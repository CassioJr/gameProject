package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import event.EnemyEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.entity.Enemy;
import model.entity.Player;
import model.entity.Spell;
import model.validation.ConditionValidation;
import util.FileManagement;
import util.Messages;
import util.Operations;

public class CombatController implements Initializable {
	@FXML
	private ImageView player, enemy;
	@FXML
	private Label nameEnemy, lifeEnemy, manaEnemy, levelPlayer, lifePlayer, manaPlayer;
	@FXML
	private TableView<Spell> listSpells;
	@FXML
	private TableColumn<Spell, String> spellName;
	@FXML
	private TableColumn<Spell, Integer> spellCost;
	@FXML
	private ListView<String> combatInfo;
	private ObservableList<Spell> skills = FXCollections.observableArrayList();
	private Enemy m;
	private Player p;

	public void listSpellsAvaiabletoUse() {
		spellName.setCellValueFactory(new PropertyValueFactory<Spell, String>("name"));
		spellCost.setCellValueFactory(new PropertyValueFactory<Spell, Integer>("cost"));
		listSpells.setItems(atualizaTabela());
	}

	public ObservableList<Spell> atualizaTabela() {
		skills = FXCollections.observableArrayList(Operations.getPlayerSpells());
		return skills;
	}

	public void useSelectedSkill(ActionEvent event) throws ClassNotFoundException, IOException {
		Spell spell = listSpells.getSelectionModel().getSelectedItem();
		if (spell != null) {
			p = FileManagement.loadPlayerData();
			combatInfoListView(Operations.playerSkillAttack(p, m, spell));
			Operations.refreshInfoIntoView(lifePlayer, manaPlayer, p);
			Operations.refreshInfoIntoView(lifeEnemy, manaEnemy, m);
			combatResult(event);
		}
	}

	public void enemySetInfo(Enemy mob) {
		m = mob;
		File file = new File(m.getImage());
		Image image = new Image(file.toURI().toString());
		enemy.setImage(image);
		nameEnemy.setText(m.getName());
		lifeEnemy.setText(String.valueOf(m.getLife()));
		manaEnemy.setText(String.valueOf(m.getMana()));
	}

	public void playerSetInfo() {
			File file = new File(FileManagement.loadPlayerData().getSpeciality().getImage());
			Image image = new Image(file.toURI().toString());
			player.setImage(image);
			levelPlayer.setText(String.valueOf(FileManagement.loadPlayerData().getLevel()));
			lifePlayer.setText(String.valueOf(FileManagement.loadPlayerData().getSpeciality().getLife()));
			manaPlayer.setText(String.valueOf(FileManagement.loadPlayerData().getSpeciality().getMana()));
	}

	public void beginCombat() {
		enemySetInfo(EnemyEvent.getInfoNotBossMobs());
	}

	public void fugir(ActionEvent event) throws IOException {
		if (Messages.MSGEscolha("Você deseja fugir?") == true) {
			changeScene(event, "View_Idle");
		}
	}

	public void atacar(ActionEvent event) throws IOException, ClassNotFoundException {
		p = FileManagement.loadPlayerData();
		combatInfoListView(Operations.playerAttack(p, m));
		Operations.refreshInfoIntoView(lifePlayer, manaPlayer, p);
		Operations.refreshInfoIntoView(lifeEnemy, manaEnemy, m);
		combatResult(event);
	}

	public void combatResult(ActionEvent event) throws IOException {
		if (ConditionValidation.vitoryCondition(m) == true) {
			Operations.getRewardsFromEnemy(p, m);
			FXMLLoader fxml = new FXMLLoader(getClass().getResource("/view/View_Victory.fxml"));
			Parent root = fxml.load();
			AfterController combate = fxml.getController();
			combate.insertValuesIntoView(m);
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} else if (ConditionValidation.defeatCondition(p) == true) {
			changeScene(event, "View_Defeat");
		}
	}

	public void combatInfoListView(String info) {
		combatInfo.getItems().addAll(info);
	}

	public void changeScene(ActionEvent event, String tela) {
		try {
			Parent fxml = FXMLLoader.load(getClass().getResource("/view/" + tela + ".fxml"));
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(new Scene(fxml));
			primaryStage.show();
		} catch (IOException e) {
			System.out.println("Erro ao carregar a tela!");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		playerSetInfo();
		listSpellsAvaiabletoUse();
	}
}
