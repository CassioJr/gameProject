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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Operacoes {
	ArrayList<Player> personagem = new ArrayList<Player>();
	ArrayList<Monsters> monstros = new ArrayList<>();

	/*
	 * Metodo que adiciona o personagem do jogador dentro do ArrayList de personagem
	 */
	public void addChar(Player jogador) {
		personagem.add(jogador);
	}

	/*
	 * Metodo que carrega as informa��es do personagem do jogador para a tela de
	 * espera Recebe como parametro o nome das labels onde se deve colocar as
	 * informa��es adquiridas do personagem
	 */
	public void carregaInformacoes(Label nome, Label level, Label coins) {
		for (Player jogador : personagem) {
			if (jogador != null) {
				nome.setText(jogador.getNome());
				level.setText(String.valueOf(jogador.getLevel()));
				coins.setText(String.valueOf(jogador.getDinheiro()));
			}
		}
	}

	/*
	 * Metodo que realiza o calculo para o dano de ataque do jogador no inimigo
	 * Recebe nos seus parametros o nome do monstro e o dano de ataque que ira
	 * realizar no inimigo
	 */
	public void danoAtaquePlayer(int dano, String nome) {
		for (Monsters m : monstros) {
			if (m.getNome().equals(nome)) {
				if (dano > m.getVida()) {
					m.setVida(0);
				} else {
					m.setVida(m.getVida() - dano);
				}

			}
		}
	}

	/*
	 * Metodo que realiza o calculo para o dano de ataque do inimigo no player
	 * Recebe nos seus parametros o dano de ataque que ir� realizar no player
	 */
	public void danoAtaqueInimigo(int dano) {
		for (Player p : personagem) {
			if (p != null) {
				if (dano > p.getVida()) {
					p.setVida(0);
				} else {
					p.setVida(p.getVida() - dano);
				}

			}
		}
	}
	
	
	//Metodo para calcular o dano da habilidade de cada classe
	public void danoHabilidade1(String nome, Button botao) {
		int rand, resta;
		Random randomizador = new Random();
		rand = randomizador.nextInt(10);
		for (Player p : personagem) {
			if (p != null && p.getClasse().equals("Mago") && !(p.getMana() < 0)) {
				danoAtaquePlayer((rand * 2), nome);
				resta = p.getMana()-20;
				p.setMana(resta);
			} else if (p != null && p.getClasse().equals("Arqueiro") && !(p.getMana() < 0)) {
				danoAtaquePlayer((rand * 2), nome);
				botao.setText("Chuva de flechas");
				resta = p.getMana()-20;
				p.setMana(resta);
			} else if (p != null && p.getClasse().equals("Guerreiro") && !(p.getMana() < 0)) {
				danoAtaquePlayer((rand * 2), nome);
				botao.setText("Avan�o do berserker");
				resta = p.getMana()-20;
				p.setMana(resta);
			}

		}
	}

		//Metodo para calcular a cura da habilidade
		public void habilidadeCura() {
			for (Player p : personagem) {
				Random randomiza = new Random();
				int cura, quantidaVida;	
				quantidaVida = p.getVida();
				if (p.getVida()<100 && p != null && p.getClasse().equals("Mago") && !(p.getMana() < 0)) {			
					cura = quantidaVida * randomiza.nextInt(18);
					p.setVida(cura);
				} else if (p != null && p.getClasse().equals("Arqueiro") && !(p.getMana() < 0)) {
					cura = quantidaVida * randomiza.nextInt(12);
					p.setVida(cura);
				} else if (p != null && p.getClasse().equals("Guerreiro") && !(p.getMana() < 0)) {
					cura = quantidaVida * randomiza.nextInt(10);
					p.setVida(cura);
				}

			}
		}
		
	/*
	 * Metodo que faz a verifica��o para a condi��o de vitoria do jogador em que
	 * recebe no seus parametros o nome do inimigo que o player esta enfrentando
	 * onde se verifica se a vida dele for 0 ir� retornar true indicando vitoria
	 * sen�o retorna false que indica que o combate continua
	 */
	public boolean condicaoVitoria(String nome) {
		for (Monsters m : monstros) {
			if (m.getNome().equals(nome)) {
				if (m.getVida() == 0)
					return true;
			}
		}
		return false;
	}

	/*
	 * Metodo que faz a verifica��o para a condi��o de derrota do jogador onde se
	 * verifica se a vida do jogador for 0 ir� retornar true indicando derrota sen�o
	 * retorna false que indica que o combate continua
	 */
	public boolean condicaoDerrota() {
		for (Player p : personagem) {
			if (p != null && p.getVida() == 0) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Metodo que faz a atualiza��o da vida e mana do inimigo durante o combate
	 * recebendo nos seus parametros o nome do monstro que se quer atualizar as
	 * informa��es e as labels de vida e mana, onde se deve atualizar as informa��es
	 */
	public void atualizaInformacoesInimigo(String nome, Label vida, Label mana) {
		for (Monsters m : monstros) {
			if (m.getNome().equals(nome)) {
				vida.setText(String.valueOf(m.getVida()));
				mana.setText(String.valueOf(m.getMana()));
			}
		}
	}

	/*
	 * Metodo que faz a atualizações da vida e mana do player durante o combate
	 * recebendo nos seus parametros as labels de vida e mana, onde se deve
	 * atualizar as informa��es
	 */
	public void atualizaInformacoesPlayer(Label vida, Label mana) {
		for (Player p : personagem) {
			if (p != null) {
				vida.setText(String.valueOf(p.getVida()));
				mana.setText(String.valueOf(p.getMana()));
			}
		}
	}

	/*
	 * Metodo que faz a atualizacão da vida e mana do player ap�s o combate ter
	 * ocorrido para 100 de vida e 100 de mana, tambem se testa para ver se o player
	 * n�o � null para que n�o ocorra erro
	 */
	public void resetaAtributos() {
		for (Player p : personagem) {
			if (p != null) {
				p.setVida(100);
				p.setMana(100);
			}
		}
	}
	
	public void mobMapa1(ImageView imageMonstro, Label vida, Label mana ) {
		File file = new File(monstros.get(0).getImage());
		Image image = new Image(file.toURI().toString());
		imageMonstro.setImage(image);
		vida.setText(String.valueOf(monstros.get(0).getVida()*2));
		mana.setText(String.valueOf(monstros.get(0).getMana()*2));
	}

	/*
	 * Metodo que pega as informa��es do monstro quando se vai iniciar o combate e
	 * seta as informa��es referente ao monstro na tela de combate recebe como
	 * parametros um ImageView onde sera colocado a imagem do monstro, e as label
	 * onde ser�o colocados as informa��es de nome, vida e mana
	 */
	public void pegaInformacoesMonstro(ImageView imagemMonstro, Label nome, Label vida, Label mana) {
		Random randomiza = new Random();
		int random = randomiza.nextInt(2);// Nesta parte � feita uma randomiza��es onde pega um numero aleatorio que ser� refente ao index do monstro no arrayList
		File file = new File(monstros.get(random).getImage());
		Image image = new Image(file.toURI().toString());
		imagemMonstro.setImage(image);
		nome.setText(monstros.get(random).getNome());
		vida.setText(String.valueOf(monstros.get(random).getVida()));
		mana.setText(String.valueOf(monstros.get(random).getMana()));
	}

	/*
	 * Metodo que pega as informa��es do player quando se vai iniciar o combate e
	 * seta as informa��es referente ao player na tela de combate recebe como
	 * parametros um ImageView onde sera colocado a imagem do monstro, e as label
	 * onde ser�o colocados as informa��es de level, vida e mana
	 */
	public void pegaInformacoeesPersonagem(ImageView imagemPersonagem, Label level, Label vida, Label mana) {
		for (Player jogador : personagem) {
			if (jogador != null) {
				// Nesta parte � pego o nome da classe do player e pega o arquivo  referente em  imagens e coloca  no ImageView
				File file = new File("./resources/Imagens_Classes/" + jogador.getClasse() + ".png");
				Image image = new Image(file.toURI().toString());
				imagemPersonagem.setImage(image);
				level.setText(String.valueOf(jogador.getLevel()));
				vida.setText(String.valueOf(jogador.getVida()));
				mana.setText(String.valueOf(jogador.getMana()));
			}
		}
	}

	/*
	 * Metodo que realiza a adi��o do gold ao player recebe como parametro a quantia
	 * de gold que sera adicionado
	 */
	public void adicionaGold(int quantia) {
		for (Player jogador : personagem) {
			if (jogador != null) {
				int valorTotal = quantia + jogador.getDinheiro();
				jogador.setDinheiro(valorTotal);
			}
		}
	}

	/*
	 * Metodo que realiza a adi��o de experiencia ao player recebe como parametro a
	 * quantia de experiencia que sera adicionado
	 */
	public void adicionaExperiencia() {
		for (Player jogador : personagem) {
			if (jogador != null) {
				if (jogador.getLevel() != 50)
					jogador.setLevel(jogador.getLevel() + 1);
			}
		}
	}

	// Metodo para verificar se existe a pasta de save no disco local C
	public void verificaPastaSave() {
		File folder = new File("C:/savedata");
		if (!folder.exists())
			folder.mkdir();
	}

	/* Metodo que salva o personagem criado pelo player em um arquivo binario */
	public boolean salvarArquivo() {
		try {// � relizado um tratamento de exe��o que caso o n�o possa ser salvo � informado
				// o erro de ("N�o foi possivel criar o arquivo")
			ObjectOutputStream output;
			output = new ObjectOutputStream(new FileOutputStream(new File("./savedata/save.bin")));
			output.writeObject(personagem);
			output.close();
			return true;
		} catch (Exception e) {
			Main.instancia().MSG("N�o foi possivel criar o arquivo");
			return false;
		}
	}

	/*
	 * Metodo que realiza a leitura do arquivo binario do personagem criado pelo
	 * player
	 */
	public boolean lerArquivo() {
		try {// � relizado um tratamento de exe��o que caso o arquivo n�o exista � informado o erro de ("N�o foi possivel ler o arquivo")
			ObjectInputStream input;
			input = new ObjectInputStream(new FileInputStream(new File("./savedata/save.bin")));
			personagem = (ArrayList<Player>) input.readObject();
			input.close();
			return true;
		} catch (Exception e) {
			Main.instancia().MSG("N�o foi possivel ler o arquivo");
			return false;
		}
	}

	/*
	 * Metodo que realiza a leitura do arquivo binario de inimigos que estarao no jogo
	 */
	public void lerArquivoMonstros() {
		try {// � relizado um tratamento de exe��o que caso o arquivo n�o exista � informado  o erro de ("N�o foi possivel ler o arquivo")
			ObjectInputStream input;
			input = new ObjectInputStream(new FileInputStream(new File("./savedata/monstros.bin")));
			monstros = (ArrayList<Monsters>) input.readObject();
			input.close();
		} catch (Exception e) {
			System.out.println(e);
			Main.instancia().MSG("N�o foi possivel ler o arquivo");
		}
	}

}
