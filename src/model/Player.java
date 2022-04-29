package model;

import java.io.Serializable;

public class Player implements Serializable{
	private String nome;
	private String classe;
	private int vida;
	private int dinheiro;
	private int mana;
	private int level;
	
	public Player(String nome,String classe) {
		this.nome = nome;
		this.classe = classe;
		this.vida = 100;
		this.mana = 100;
		this.level = 1;
		this.dinheiro = 0;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}

	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
}
