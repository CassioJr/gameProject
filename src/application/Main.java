package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Stage stage;
	private static Scene main;
	private static Scene NovoJogo;
	
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
			
			stage.setScene(main);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void changeScene(String scr) {
		switch (scr) {
		case "Menu":
			stage.setScene(main);
			break;
		case "novoJogo":
			stage.setScene(NovoJogo);
			break;	
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
