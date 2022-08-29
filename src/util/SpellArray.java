package util;

import java.util.ArrayList;
import java.util.List;

import model.entity.Spell;

public final class SpellArray {
    private static SpellArray instance;
    private List<Spell> spells = new ArrayList<Spell>();

    public static SpellArray getInstance() {
        if (instance == null) {
            instance = new SpellArray();
        }
        return instance;
    }
    
    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }
}
