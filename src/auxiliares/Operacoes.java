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
	
	/*Metodo que adiciona o personagem do jogador dentro do ArrayList de personagem*/
	public void addChar(Player jogador) {
		personagem.add(jogador);
	}
	
	/*Metodo que carrega as informações do personagem do jogador para a tela de espera
	 * Recebe como parametro o nome das labels onde se deve colocar as informações adquiridas do personagem*/
	public void carregaInformacoes(Label nome, Label level, Label coins) {
		for (Player jogador : personagem) {
			if (jogador != null) {
				nome.setText(jogador.getNome());
				level.setText(String.valueOf(jogador.getLevel()));
				coins.setText(String.valueOf(jogador.getDinheiro()));
			}
		}
	}
	
	/*Metodo que realiza o calculo para o dano de ataque do jogador no inimigo
	 * Recebe nos seus parametros o nome do monstro e o dano de ataque que ira realizar no inimigo*/
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
	
	/*Metodo que realiza o calculo para o dano de ataque do inimigo no player
	 * Recebe nos seus parametros o dano de ataque que irá realizar no player*/
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
	
	public void danoHabilidade1(int rand, String nome) {
		for(Player p : personagem ) {
			if(p != null && p.getClasse().equals("Mago") && p.getMana() < 0){
				danoAtaquePlayer((rand*2), nome);
				}
			else if (p != null && p.getClasse().equals("Arqueiro") && p.getMana() < 0) {
				
				danoAtaquePlayer((rand*2), nome);
			}
			}
	}
	
	/*Metodo que faz a verificação para a condição de vitoria do jogador
	 * em que recebe no seus parametros o nome do  inimigo que o player esta enfrentando
	 * onde se verifica se a vida dele for 0 irá retornar true indicando vitoria senão retorna false
	 * que indica que o combate continua*/
	public boolean condicaoVitoria(String nome) {
		for(Monsters m :monstros ) {
			if(m.getNome().equals(nome)) {
				if(m.getVida() == 0)
					return true;
			}
		}
		return false;
	}
	
	/*Metodo que faz a verificação para a condição de derrota do jogador
	 * onde se verifica se a vida do jogador for 0 irá retornar true indicando derrota 
	 * senão retorna false que indica que o combate continua*/
	public boolean condicaoDerrota() {
		for(Player p :personagem ) {
			if(p != null && p.getVida() == 0) {
					return true;
			}
		}
		return false;
	}
	
	/*Metodo que faz a atualização da vida e mana do inimigo durante o combate
	 * recebendo nos seus parametros o nome do monstro que se quer atualizar as informações
	 * e as labels de vida e mana, onde se deve atualizar as informações*/
	public void atualizaInformacoesInimigo(String nome,Label vida,Label mana) {
		for(Monsters m :monstros ) {
			if(m.getNome().equals(nome)) {
		vida.setText(String.valueOf(m.getVida()));
		mana.setText(String.valueOf(m.getMana()));
			}
		}
	}
	
	/*Metodo que faz a atualização da vida e mana do player durante o combate
	 * recebendo nos seus parametros as labels de vida e mana, onde se deve atualizar as informações*/
	public void atualizaInformacoesPlayer(Label vida,Label mana) {
		for(Player p :personagem ) {
			if( p!= null) {
		vida.setText(String.valueOf(p.getVida()));
		mana.setText(String.valueOf(p.getMana()));
			}
		}
	}
	
	/*Metodo que faz a atualização da vida e mana do player após o combate 
	 * ter ocorrido para 100 de vida e 100 de mana, tambem se testa para ver se o player
	 * não é null para que não ocorra erro*/
	public void resetaAtributos() {
		for(Player p :personagem ) {
			if(p != null) {
				p.setVida(100);
				p.setMana(100);
				}
			}
	}
	
	/*Metodo que pega as informações do monstro quando se vai iniciar o combate e seta as informações referente ao monstro na tela de combate
	 *recebe como parametros um ImageView onde sera colocado a imagem do monstro, e as label onde serão colocados as informações de nome, vida e mana*/
	public void pegaInformaçõesMonstro(ImageView imagemMonstro, Label nome,Label vida,Label mana) {
		Random randomiza = new Random();
		int random = randomiza.nextInt(2);//Nesta parte é feita uma randomizações onde pega um numero aleatorio que será refente ao index do monstro no arrayList 
		File file = new File(monstros.get(random).getImage());
		Image image = new Image(file.toURI().toString());
		imagemMonstro.setImage(image);
		nome.setText(monstros.get(random).getNome());
		vida.setText(String.valueOf(monstros.get(random).getVida()));
		mana.setText(String.valueOf(monstros.get(random).getMana()));
	}
	
	/*Metodo que pega as informações do player quando se vai iniciar o combate e seta as informações referente ao player na tela de combate
	 *recebe como parametros um ImageView onde sera colocado a imagem do monstro, e as label onde serão colocados as informações de level, vida e mana*/
	public void pegaInformaçõesPersonagem(ImageView imagemPersonagem, Label level,Label vida,Label mana) {
		for (Player jogador : personagem) {
			if (jogador != null) {
		File file = new File("./resources/Imagens_Classes/"+jogador.getClasse()+".png");//Nesta parte é pego o nome da classe do player e pega o arquivo referente em imagens e coloca no ImageView
		Image image = new Image(file.toURI().toString());
		imagemPersonagem.setImage(image);
		level.setText(String.valueOf(jogador.getLevel()));
		vida.setText(String.valueOf(jogador.getVida()));
		mana.setText(String.valueOf(jogador.getMana()));
			}
		}
	}
	
	/*Metodo que realiza a adição do gold ao player
	 * recebe como parametro a quantia de gold que sera adicionado*/
	public void adicionaGold(int quantia) {
		for (Player jogador : personagem) {
			if (jogador != null) {
				int valorTotal = quantia+jogador.getDinheiro();
				jogador.setDinheiro(valorTotal);
				}
			}
	}
	
	/*Metodo que realiza a adição de experiencia ao player
	 * recebe como parametro a quantia de experiencia que sera adicionado*/
	public void adicionaExperiencia() {
		for (Player jogador : personagem) {
			if (jogador != null) {
				if(jogador.getLevel() != 50)
				jogador.setLevel(jogador.getLevel()+1);
				}
			}
	}

	/*Metodo que salva o personagem criado pelo player em um arquivo binario*/
	public boolean salvarArquivo() {
		try {//É relizado um tratamento de exeção que caso o não possa ser salvo é informado o erro de ("Não foi possivel criar o arquivo")
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

	/*Metodo que realiza a leitura do arquivo binario do personagem criado pelo player*/
	public boolean lerArquivo() {
		try {//É relizado um tratamento de exeção que caso o arquivo não exista é informado o erro de ("Não foi possivel ler o arquivo")
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
	
	/*Metodo que realiza a leitura do arquivo binario de inimigos que estarao no jogo*/
	public void lerArquivoMonstros() {
		try {//É relizado um tratamento de exeção que caso o arquivo não exista é informado o erro de ("Não foi possivel ler o arquivo")
			ObjectInputStream input;
			input = new ObjectInputStream(new FileInputStream(new File("./savedata/monstros.bin")));
			monstros = (ArrayList<Monsters>) input.readObject();
			input.close();
		} catch (Exception e) {
			System.out.println(e);
			Main.instancia().MSG("Não foi possivel ler o arquivo");
		}
	}
	

}

