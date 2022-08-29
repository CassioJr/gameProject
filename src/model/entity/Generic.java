package model.entity;

import java.io.Serializable;

public abstract class Generic implements Serializable {
    private String name;
    private int life;
    private int mana;

    protected Generic(String name, int life, int mana) {
        this.name = name;
        this.life = life;
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public int getMana() {
        return mana;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
