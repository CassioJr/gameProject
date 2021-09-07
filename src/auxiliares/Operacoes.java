package auxiliares;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import application.Main;
import classesEntidades.Monsters;
import classesEntidades.Player;
import javafx.scene.control.Label;

public class Operacoes {
	ArrayList<Player> personagem = new ArrayList<Player>();
	ArrayList<Monsters> monstros = new ArrayList<Monsters>();
	
	public void addChar(Player jogador) {
		personagem.add(jogador);
	}
	
	public void addMonster(Monsters monstro) {
		monstros.add(monstro);
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

	public boolean salvarArquivo() {
		try {
			ObjectOutputStream output;
			output = new ObjectOutputStream(new FileOutputStream(new File("./savedata/save.bin")));
			output.writeObject(personagem);
			output.close();
			return true;
		} catch (Exception e) {
			Main.instancia().MSG("Não foi possivel criar o arquivo");
			return false;
		}
	}

	public boolean lerArquivo() {
		try {
			ObjectInputStream input;
			input = new ObjectInputStream(new FileInputStream(new File("./savedata/save.bin")));
			personagem = (ArrayList<Player>) input.readObject();
			input.close();
			return true;
		} catch (Exception e) {
			Main.instancia().MSG("Não foi possivel ler o arquivo");
			return false;
		}
	}
}
