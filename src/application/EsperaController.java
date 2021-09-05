package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EsperaController{
    @FXML
    private Label nomePlayer;

    @FXML
    private Label nivelPlayer;

    @FXML
    private Label ouroPlayer;
    
    public void Informacoes() {
    	Main.operacoes().carregaInformacoes(nomePlayer, nivelPlayer, ouroPlayer);
    }
    
    public void menu() {
    	Main.changeScene("Menu");
    }
}
