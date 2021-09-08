package auxiliares;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import application.Main;
import classesEntidades.Monsters;
import classesEntidades.Player;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Operacoes {
	ArrayList<Player> personagem = new ArrayList<Player>();
	ArrayList<Monsters> monstros = new ArrayList<>();
	
	public void addChar(Player jogador) {
		personagem.add(jogador);
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
	
	public void danoAtaquePlayer(int dano, String nome) {
		for(Monsters m :monstros ) {
			if(m.getNome().equals(nome)) {
				if(dano>m.getVida()) {
					m.setVida(0);
				}else {
					m.setVida(m.getVida()-dano);
				}
			
			}
		}
	}
	
	public void danoAtaqueInimigo(int dano) {
		for(Player p :personagem ) {
			if(p != null) {
				if(dano>p.getVida()) {
					p.setVida(0);
				}else {
					p.setVida(p.getVida()-dano);
				}
			
			}
		}
	}
	public boolean condicaoVitoria(String nome) {
		for(Monsters m :monstros ) {
			if(m.getNome().equals(nome)) {
				if(m.getVida() == 0)
					return true;
			}
		}
		return false;
	}
	
	public void atualizaInformacoesInimigo(String nome,Label vida,Label mana) {
		for(Monsters m :monstros ) {
			if(m.getNome().equals(nome)) {
		vida.setText(String.valueOf(m.getVida()));
		mana.setText(String.valueOf(m.getMana()));
			}
		}
	}
	
	public void atualizaInformacoesPlayer(Label vida,Label mana) {
		for(Player p :personagem ) {
			if( p!= null) {
		vida.setText(String.valueOf(p.getVida()));
		mana.setText(String.valueOf(p.getMana()));
			}
		}
	}
	
	public void resetaAtributos() {
		for(Player p :personagem ) {
			if(p != null) {
				p.setVida(100);
				p.setMana(100);
				}
			}
	}
	
	public void pegaInformaçõesMonstro(ImageView imagemMonstro, Label nome,Label vida,Label mana) {
		Random randomiza = new Random();
		int random = randomiza.nextInt(2);
		File file = new File(monstros.get(random).getImage());
		Image image = new Image(file.toURI().toString());
		imagemMonstro.setImage(image);
		nome.setText(monstros.get(random).getNome());
		vida.setText(String.valueOf(monstros.get(random).getVida()));
		mana.setText(String.valueOf(monstros.get(random).getMana()));
	}
	
	public void pegaInformaçõesPersonagem(ImageView imagemPersonagem, Label level,Label vida,Label mana) {
		for (Player jogador : personagem) {
			if (jogador != null) {
		File file = new File("./resources/Imagens_Classes/Guerreiro.png");
		Image image = new Image(file.toURI().toString());
		imagemPersonagem.setImage(image);
		level.setText(String.valueOf(jogador.getLevel()));
		vida.setText(String.valueOf(jogador.getVida()));
		mana.setText(String.valueOf(jogador.getMana()));
			}
		}
	}
	
	public void adicionaGold(int quantia) {
		for (Player jogador : personagem) {
			if (jogador != null) {
				int valorTotal = quantia+jogador.getDinheiro();
				jogador.setDinheiro(valorTotal);
				}
			}
	}
	
	public void adicionaExperiencia() {
		for (Player jogador : personagem) {
			if (jogador != null) {
				if(jogador.getLevel() != 50)
				jogador.setLevel(jogador.getLevel()+1);
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
	
	public void lerArquivoMonstros() {
		try {
			ObjectInputStream input;
			input = new ObjectInputStream(new FileInputStream(new File("C:/Users/Cassio/Desktop/Projetos/Game/GameProject/savedata/monstros.bin")));
			monstros = (ArrayList<Monsters>) input.readObject();
			input.close();
		} catch (Exception e) {
			System.out.println(e);
			Main.instancia().MSG("Não foi possivel ler o arquivo");
		}
	}
	

}

