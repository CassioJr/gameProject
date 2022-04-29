package application;

import controller.CombateController;
import javafx.application.Application;
import javafx.stage.Stage;
import utils.MetodosAuxiliares;
import utils.Operacoes;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	public static MetodosAuxiliares ma;
	public static Operacoes op;
	public static CombateController cc;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Função onde se coloca um titulo para o programa
			primaryStage.setTitle("Aqui vai o nome do jogo kkkkkkkk");

			// Função onde indica que a tela do programa não pode ser redimensionada
			primaryStage.setResizable(false);

			// Esse codigo serve para colocar icone no aplicativo
			// stage.getIcons().add(new Image("file:imagens//dk.jpg"));

			// Função onde se chama a tela de menu
			AnchorPane fxmlmenu = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/TelaMenu.fxml"));
			Scene main = new Scene(fxmlmenu);
			primaryStage.setScene(main);
			primaryStage.show();

		} catch (Exception e) {
		}
	}

	/*
	 * Metodo para que não precise instanciar toda hora a classe de
	 * MetodosAuxiliares
	 */
	public static MetodosAuxiliares instancia() {
		if (ma == null) {
			ma = new MetodosAuxiliares();
		}
		return ma;
	}

	/* Metodo para que não precise instanciar toda hora a classe de Operacoes */
	public static Operacoes operacoes() {
		if (op == null) {
			op = new Operacoes();
		}
		return op;
	}

	/*
	 * public static CombateController combate() {
	 * if (cc == null) {
	 * cc = cc = new CombateController();
	 * }
	 * return cc;
	 * }
	 */

	public static void main(String[] args) {
		launch(args);
	}
}
