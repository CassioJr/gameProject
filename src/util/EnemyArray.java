package util;

import java.util.ArrayList;
import java.util.List;

import model.entity.Enemy;

public class EnemyArray {
    private static EnemyArray instance;
    private List<Enemy> enemys = new ArrayList<Enemy>();

    public static EnemyArray getInstance() {
        if (instance == null) {
            instance = new EnemyArray();
        }
        return instance;
    }

 public List<Enemy> getEnemy() {
     return enemys;
 }
 public void setEnemy(List<Enemy> enemy) {
     this.enemys = enemy;
 }
}
