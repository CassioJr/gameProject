package event;

import model.entity.Enemy;
import model.entity.Player;
import util.Messages;

public class MapEvent {

    public static Enemy dragonEvent() {
        return EnemyEvent.getSpecificMobByName("Dragão", "Commun");
    }

    public static Enemy dragonEventBoss() {
        return EnemyEvent.getSpecificMobByName("Dragão das tempestades", "Boss");
    }

    public static Enemy reignEvent() {
        return EnemyEvent.getSpecificMobByID(6);
    }

    public static Enemy fortEvent(Player p) {
        if (p.getLevel() == 9) {
            return EnemyEvent.getInfoBossMobs();
        }
        Messages.MSG("É necessario nivel 9");
        return null;
    }

    public static Enemy orcVillageEvent() {
        return EnemyEvent.getSpecificMobByName("Orc", "Commun");
    }

    public static Enemy winterVillageEvent() {
        return EnemyEvent.getSpecificMobByID(5);
    }

    public static Enemy catedralEvent() {
        return EnemyEvent.getSpecificMobByID(10);
    }

    public static Enemy seaCreatureEvent(Player p) {
        if (p.getLevel() == 10) {
        return EnemyEvent.getSpecificMobByID(9);
        }
        Messages.MSG("É necessario nivel 10");
        return null;
    }

    public static Enemy battleAcampamentEvent() {
        return EnemyEvent.getSpecificMobByID(2);
    }
}
