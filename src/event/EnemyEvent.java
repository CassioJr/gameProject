package event;

import java.util.Random;

import model.entity.Enemy;
import model.validation.ConditionValidation;
import util.FileManagement;

public class EnemyEvent {

    public static int randomizeMobs(int id) {
        Random rand = new Random();
        return ConditionValidation.existMonster(rand.nextInt(id));
    }

    public static Enemy getInfoNotBossMobs() {
        for (Enemy m : FileManagement.readEnemyFile().getEnemy()) {
            int random = randomizeMobs(FileManagement.readEnemyFile().getEnemy().size());
            if(!m.getType().equals("Boss") && m.getId() ==  random && m != null){
                return m;
            }
        }
        return getInfoNotBossMobs();
    }

    public static Enemy getInfoBossMobs() {
        for (Enemy m : FileManagement.readEnemyFile().getEnemy()) {
            if(m.getType().equals("Boss") && m.getId() == randomizeMobs(FileManagement.readEnemyFile().getEnemy().size()) && m!=null){
                return m;
            }
        }
        return getInfoBossMobs();
    }

    public static Enemy getSpecificMobByID(int id){
        for (Enemy m : FileManagement.readEnemyFile().getEnemy()) {
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public static Enemy getSpecificMobByName(String name, String type){
        for (Enemy m : FileManagement.readEnemyFile().getEnemy()) {
            if(m.getName().contains(name) && m.getType().equals(type)){
                return m;
            }
        }
        return null;
    }
}
