package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("RPGQuest");
			primaryStage.setResizable(false);
			// stage.getIcons().add(new Image("file:imagens//dk.jpg"));
			AnchorPane fxmlmenu = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/View_Menu.fxml"));
			Scene main = new Scene(fxmlmenu);
			primaryStage.setScene(main);
			primaryStage.show();
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
