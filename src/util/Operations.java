package util;

import java.io.IOException;
import java.util.List;

import event.DamageCalculationEvent;
import event.RewardsEvent;
import javafx.scene.control.Label;
import model.entity.Enemy;
import model.entity.Player;
import model.entity.Speciality;
import model.entity.Spell;
import model.validation.ConditionValidation;
import model.validation.TurnValidation;

public class Operations {

	public static String playerAttack(Player p, Enemy m) throws ClassNotFoundException, IOException {
		return TurnValidation.playerTurn(p.getSpeciality().getBaseDamage(), m) + TurnValidation.enemyTurn(p, m);
	}

	public static String playerSkillAttack(Player p, Enemy m, Spell spell) throws ClassNotFoundException, IOException {
		if (ConditionValidation.haveManaPlayer(p, spell)) {
			DamageCalculationEvent.calculeManaCost(p, spell.getCost());
			return "O jogador usou " + spell.getName() + "\n" + TurnValidation.playerTurn(spell.getBaseDamage(), m)
					+ TurnValidation.enemyTurn(p, m);
		}
		return "Sem mana";
	}

	public static void refreshInfoIntoView(Label vida, Label mana, Object obj) {
		if (obj instanceof Enemy) {
			vida.setText(String.valueOf(((Enemy) obj).getLife()));
			mana.setText(String.valueOf(((Enemy) obj).getMana()));
		} else if (obj instanceof Player) {
			vida.setText(String.valueOf(((Player) obj).getSpeciality().getLife()));
			mana.setText(String.valueOf(((Player) obj).getSpeciality().getMana()));
			refreshInfoPlayerIntoFile((Player) obj);
		}
	}

	public static List<Spell> getPlayerSpells() {
		FileManagement.readSpellFile();
		for (Speciality s : FileManagement.readSpecialityFile().getClasses()) {
			return s.getSkills();
		}
		return null;
	}

	public static void refreshInfoPlayerIntoFile(Player p) {
		try {
			FileManagement.savePlayerData(p);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void resetPlayerAttributes(Player p) {
		for (Speciality s : FileManagement.readSpecialityFile().getClasses()) {
			if (p.getSpeciality().getName().equals(s.getName())) {
				p.getSpeciality().setLife(s.getLife());
				p.getSpeciality().setMana(s.getMana());
			}
		}
		refreshInfoPlayerIntoFile(p);
	}

	public static void getRewardsFromEnemy(Player p, Enemy m) {
		try {
			RewardsEvent.isMonsterDefeat(p, m);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
