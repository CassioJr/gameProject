package application;


import auxiliares.MetodosAuxiliares;
import auxiliares.Operacoes;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Stage stage;
	private static Scene main;
	private static Scene NovoJogo;
	private static Scene Espera;
	public static MetodosAuxiliares ma;
	public static Operacoes op;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			stage.setTitle("Aqui vai o nome do jogo kkkkkkkk");
			stage.setResizable(false);
			//Esse codigo serve pra bota icone no aplicativo 
			//stage.getIcons().add(new Image("file:imagens//dk.jpg"));
						
			AnchorPane fxmlmenu = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaMenu.fxml"));
			main = new Scene(fxmlmenu);
		
			AnchorPane fxmlCharCreation = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaCriacaoPersonagem.fxml"));
			NovoJogo = new Scene(fxmlCharCreation);
			
			AnchorPane fxmlEspera = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaEspera.fxml"));
			Espera = new Scene(fxmlEspera);
			
			stage.setScene(main);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Metodo que serve pra ser chamado e trocar de tela mais pratico
	public static void changeScene(String scr) {
		switch (scr) {
		case "Menu":
			stage.setScene(main);
			break;
		case "novoJogo":
			stage.setScene(NovoJogo);
			break;	
		case "espera":
			stage.setScene(Espera);
			break;	
	}
	}
	
	public static MetodosAuxiliares instancia() {
		if (ma == null) {
			ma = new MetodosAuxiliares();
		}
		return ma;
	}
	
	public static Operacoes operacoes() {
		if (op == null) {
			op = new Operacoes();
		}
		return op;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
