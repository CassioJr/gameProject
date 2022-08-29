package event;

import java.util.Random;
import model.entity.Enemy;
import model.entity.Player;
import model.entity.Spell;

public class DamageCalculationEvent {
	private static Random rand = new Random();;

	public static int damageCalculation(int damage, int armor) {
		return (rand.nextInt(21) + damage) - armor;
	}

	public static int playerAttackDamage(int dmg, Enemy m) {
		int playerdmg = damageCalculation(dmg, m.getBaseArmor());
		if (playerdmg > m.getLife()) {
			m.setLife(0);
		} else {
			m.setLife(m.getLife() - playerdmg);
		}
		return playerdmg;
	}

	public static Spell randomSkillAttackEnemy(Enemy m) {
		return m.getSkills().get(rand.nextInt(m.getSkills().size()));
	}

	public static int randomizeAttackEnemy() {
		return rand.nextInt(2);
	}

	public static int enemyAttackDamageSpell(Player p, int dmg) {
		int spelldmg = damageCalculation(dmg, p.getSpeciality().getBaseArmor());
		if (p != null) {
			if (spelldmg > p.getSpeciality().getLife()) {
				p.getSpeciality().setLife(0);
			} else {
				p.getSpeciality().setLife(p.getSpeciality().getLife() - spelldmg);
			}
		}
		return spelldmg;
	}

	public static int enemyAttackDamage(Player p, Enemy m) {
		int dmg = damageCalculation(m.getBaseDamage(), p.getSpeciality().getBaseArmor());
		if (p != null) {
			if (dmg > p.getSpeciality().getLife()) {
				p.getSpeciality().setLife(0);
			} else {
				p.getSpeciality().setLife(p.getSpeciality().getLife() - dmg);
			}
		}
		return dmg;
	}

	public static void calculeManaCost(Object obj, int cost) {
		if (obj instanceof Player) {
			((Player) obj).getSpeciality().setMana(((Player) obj).getSpeciality().getMana() - cost);
		} else if (obj instanceof Enemy) {
			((Enemy) obj).setMana(((Enemy) obj).getMana() - cost);
		}
	}
}
