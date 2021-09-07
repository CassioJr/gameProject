package application;


import auxiliares.MetodosAuxiliares;
import auxiliares.Operacoes;
import javafx.application.Application;
import javafx.stage.Stage;
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
			primaryStage.setTitle("Aqui vai o nome do jogo kkkkkkkk");
			primaryStage.setResizable(false);
			//Esse codigo serve pra bota icone no aplicativo 
			//stage.getIcons().add(new Image("file:imagens//dk.jpg"));
						
			AnchorPane fxmlmenu = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaMenu.fxml"));
			Scene main = new Scene(fxmlmenu);

			primaryStage.setScene(main);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
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
	
	public static CombateController combate() {
		if (cc == null) {
			cc = cc = new CombateController();
		}
		return cc;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
