package model;

import java.io.Serializable;

public class Monsters implements Serializable{
	String image;
	String nome;
	int vida;
	int mana;
	
	public Monsters (String image,String nome, int vida, int mana) {
		this.image = image;
		this.nome = nome;
		this.vida = vida;
		this.mana = mana;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	

}
