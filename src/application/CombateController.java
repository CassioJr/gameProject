package application;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CombateController {
	@FXML
	private ImageView inimigo;
	@FXML
	private ImageView jogador;
	
	public void randomizaCombate() {}
	
	public void mobMapaDragao1() {
		File file = new File("./Monsters/dragon.png");
		Image image = new Image(file.toURI().toString());
		inimigo.setImage(image);
	}
}
