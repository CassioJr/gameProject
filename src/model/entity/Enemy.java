package model.entity;

import java.util.ArrayList;

public class Enemy extends Generic {
	private int id;
	private String image;
	private String type;
	private int baseDamage;
	private int baseArmor;
	private long reward;
	private Long xpReward;
	private ArrayList<Spell> skills;

	public Enemy(int id, String image, String name, int life, int mana, ArrayList<Spell> skills, String type,
			int baseDamage,
			int baseArmor, long reward, Long xp) {
		super(name, life, mana);
		this.id = id;
		this.image = image;
		this.skills = skills;
		this.type = type;
		this.reward = reward;
		this.baseDamage = baseDamage;
		this.baseArmor = baseArmor;
		this.xpReward = xp;
	}

	public int getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public String getType() {
		return type;
	}

	public long getReward() {
		return reward;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public int getBaseArmor() {
		return baseArmor;
	}

	public ArrayList<Spell> getSkills() {
		return skills;
	}

	public Long getXpReward() {
		return xpReward;
	}

	public void setSkills(ArrayList<Spell> skills) {
		this.skills = skills;
	}

	public void setReward(long reward) {
		this.reward = reward;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setBaseArmor(int baseArmor) {
		this.baseArmor = baseArmor;
	}

	public void setXpReward(Long xpReward) {
		this.xpReward = xpReward;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getId() + getName() + " " + getImage() + " " + getSkills().toString();
	}
}
