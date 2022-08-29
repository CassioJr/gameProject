package model.validation;

import model.entity.Enemy;
import model.entity.Player;
import model.entity.Spell;

public class ConditionValidation {

	public static boolean vitoryCondition(Enemy m) {
		if (m.getLife() == 0)
			return true;
		else
			return false;
	}

	public static boolean defeatCondition(Player p) {
		if (p != null && p.getSpeciality().getLife() == 0)
			return true;
		else
			return false;
	}

	public static int existMonster(int id) {
		if (id > 0) {
			return id;
		}
		return 1;
	}

	public static boolean haveManaPlayer(Player p, Spell spell) {
		if (p.getSpeciality().getMana() < spell.getCost())
			return false;
		else
			return true;
	}

	public static boolean haveManaEnemy(Enemy m, Spell spell) {
		if (m.getMana() < spell.getCost())
			return false;
		else
			return true;
	}

}
