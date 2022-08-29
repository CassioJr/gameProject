package util;

import java.util.ArrayList;
import java.util.List;

import model.entity.Speciality;

public final class SpecialityArray {
    private static SpecialityArray instance;
    private List<Speciality> classes = new ArrayList<Speciality>();

    public static SpecialityArray getInstance() {
        if (instance == null) {
            instance = new SpecialityArray();
        }
        return instance;
    }

    public Speciality specialityLoad(String name) {
        for (Speciality speciality : FileManagement.readSpecialityFile().getClasses()) {
            if (speciality.getName().equals(name)) {
                return speciality;
            }
        }
        return null;
    }

    public List<Speciality> getClasses() {
        return classes;
    }

    public void setClasses(List<Speciality> classes) {
        this.classes = classes;
    }
}
