package model.entity;

import java.io.Serializable;

public class Player implements Serializable {
	private Speciality speciality;
	private String name;
	private long money;
	private int level;
	private long xp;

	public Player(String name, Speciality speciality) {
		this.name = name;
		this.speciality = speciality;
		this.xp = 0;
		this.level = 1;
		this.money = 0;
	}

	public String getName() {
		return name;
	}

	public long getMoney() {
		return money;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public int getLevel() {
		return level;
	}

	public long getXp() {
		return xp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setXp(long xp) {
		this.xp = xp;
	}

	@Override
	public String toString() {
		return getName()+" "+getMoney()+ " "+getSpeciality()+ getSpeciality().getSkills().toString();
	}
}
