package model.validation;

import model.entity.Player;
import model.enums.Level;

public class LevelValidation {
    public static boolean isMaxLevel(Player p) {
        if (p != null && p.getLevel() == 50) {
            return true;
        }
        return false;
    }

    public static int verifyLevel(Player p) {
        for (Level lvl : Level.values()) {
            if (p.getLevel() == lvl.getLevel()) {
                System.out.println("O necessario é " + lvl.getNecessaryXP());
                return lvl.getNecessaryXP();
            }
        }
        return 1000000;
    }

    public static boolean isAbletoUP(Player p) {
        if (p.getXp() >= verifyLevel(p))
            return true;
        else
            return false;
    }
}
