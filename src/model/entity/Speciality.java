package model.entity;

import java.util.ArrayList;

public class Speciality extends Generic {
    private String image;
    private int baseDamage;
    private String baseDamageType;
    private int baseArmor;
    private ArrayList<Spell> skills;

    public Speciality(String image, String name, int life, int mana, int baseDamage, String baseDamageType,
            ArrayList<Spell> skills) {
        super(name, life, mana);
        this.image = image;
        this.baseDamage = baseDamage;
        this.baseDamageType = baseDamageType;
        this.skills = skills;
    }

    public int getBaseArmor() {
        return baseArmor;
    }

    public String getImage() {
        return image;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public String getBaseDamageType() {
        return baseDamageType;
    }

    public ArrayList<Spell> getSkills() {
        return skills;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setSkills(ArrayList<Spell> skills) {
        this.skills = skills;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void setBaseArmor(int baseArmor) {
        this.baseArmor = baseArmor;
    }

    public void setBaseDamageType(String baseDamageType) {
        this.baseDamageType = baseDamageType;
    }

    @Override
    public String toString() {
        return getName();
    }
}
