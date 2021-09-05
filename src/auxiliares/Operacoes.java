package auxiliares;

import java.util.ArrayList;

import classesEntidades.Player;
import javafx.scene.control.Label;

public class Operacoes {
	ArrayList<Player> personagem = new ArrayList<Player>();
	
	public void addChar(Player nome) {
		personagem.add(nome);
	}
	
    public void carregaInformacoes(Label nome, Label level, Label coins) {
    	for(Player jogador : personagem) {
    	//nome.setText(jogador.getNome());
    	level.setText(String.valueOf(jogador.getLevel()));
    	coins.setText(String.valueOf(jogador.getDinheiro()));
    	}
    	}
    
    public void SalvarArquivo() {}
}
