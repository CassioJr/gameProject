package application;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CharCreationController {
@FXML
private ImageView classeImagem;
@FXML
private MenuButton escolherClasse;
@FXML
private MenuItem mago;

public void mago() {
	escolherClasse.setText(mago.getText());
    File file = new File("C:/Users/Cassio/Desktop/Projetos/Game/GameProject/Imagens_Classes/Mago.png");
    Image image = new Image(file.toURI().toString());
	classeImagem.setImage(image);
}

}
