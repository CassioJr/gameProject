package model.entity;

import java.io.Serializable;

public class Spell implements Serializable{
    private long id;
    private String name;
    private int cost;
    private int baseDamage;
    private int baseHeal;
    private int duration;
    private String type;

    public Spell(String name, int cost, int duration, Long id) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getDuration() {
        return duration;
    }

    public String getType() {
        return type;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getBaseHeal() {
        return baseHeal;
    }

    public long getId() {
        return id;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public void setCost(int custo) {
        this.cost = custo;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setId(long id) {
        this.id = id;
    }
}