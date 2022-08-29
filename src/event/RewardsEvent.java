package event;

import java.io.IOException;

import model.entity.Enemy;
import model.entity.Player;
import model.validation.LevelValidation;
import util.FileManagement;

public class RewardsEvent {

    public static void gainExp(Player p, Enemy m) throws IOException, ClassNotFoundException {
        p.setXp(p.getXp() + m.getXpReward());
        System.out.println("O premio é "+ m.getXpReward());
        FileManagement.savePlayerData(p);
    }

    public static void gainLevel(Player p) throws ClassNotFoundException, IOException {
        p.setLevel(p.getLevel() + 1);
        FileManagement.savePlayerData(p);
    }

    public static void isLevelUp(Player p, Enemy m) throws ClassNotFoundException, IOException {
        System.out.println("Xp do jogador: " + p.getXp());
        if (LevelValidation.isMaxLevel(p) == false) {
            gainExp(p, m);
            if (LevelValidation.isAbletoUP(p) == true) {
                gainLevel(p);
            }
        }
    }

    public static void isMonsterDefeat(Player p, Enemy m) throws ClassNotFoundException, IOException {
        gainMoney(p, m);
        isLevelUp(p, m);
    }

    public static void gainMoney(Player p, Enemy m) {
        p.setMoney(p.getMoney() + m.getReward());
    }
}
