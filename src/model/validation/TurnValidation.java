package model.validation;

import event.DamageCalculationEvent;
import model.entity.Enemy;
import model.entity.Player;
import model.entity.Spell;

public class TurnValidation {
	private static boolean turnoPlayer = true;

	public static String playerTurn(int dmg, Enemy m) {
		if (turnoPlayer == true)
			changeTurn();
		return " O jogador causou " + DamageCalculationEvent.playerAttackDamage(dmg, m) + " de dano";
	}

	public static void changeTurn() {
		if (turnoPlayer == true)
			turnoPlayer = false;
		else
			turnoPlayer = true;
	}

	public static String enemyTurn(Player p, Enemy m) {
		if (turnoPlayer == false) {
			changeTurn();
			if (DamageCalculationEvent.randomizeAttackEnemy() == 2) {
				Spell s = DamageCalculationEvent.randomSkillAttackEnemy(m);
				if (ConditionValidation.haveManaEnemy(m, s))
					DamageCalculationEvent.calculeManaCost(m, s.getCost());
				return " O inmigo causou" + DamageCalculationEvent.enemyAttackDamageSpell(p, s.getBaseDamage())
						+ " de dano com " + s.getName();
			} else {
				return " O inmigo causou" + DamageCalculationEvent.enemyAttackDamage(p, m) + " de dano ";
			}
		}
		return null;
	}

}
