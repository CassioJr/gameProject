package auxiliares;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import application.Main;
import classesEntidades.Player;
import javafx.scene.control.Label;

public class Operacoes {
	ArrayList<Player> personagem = new ArrayList<Player>();

	public void addChar(Player nome) {
		personagem.add(nome);
	}

	public void carregaInformacoes(Label nome, Label level, Label coins) {
		for (Player jogador : personagem) {
			if (jogador != null) {
				nome.setText(jogador.getNome());
				level.setText(String.valueOf(jogador.getLevel()));
				coins.setText(String.valueOf(jogador.getDinheiro()));
			}
		}
	}

	public void salvarArquivo() {
		try {
			ObjectOutputStream output;
			output = new ObjectOutputStream(new FileOutputStream(new File(".\\savedata\\save.bin")));
			output.writeObject(personagem);
			output.close();
		} catch (Exception e) {
			Main.instancia().MSG("Não foi possivel criar o arquivo");
		}
	}

	public void lerArquivo() {
		try {
			ObjectInputStream input;
			input = new ObjectInputStream(new FileInputStream(new File(".\\\\savedata\\\\save.bin")));
			personagem = (ArrayList<Player>) input.readObject();
			input.close();
		} catch (Exception e) {
			Main.instancia().MSG("Não foi possivel ler o arquivo");
		}
	}
}
