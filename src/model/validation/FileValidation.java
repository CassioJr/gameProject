package model.validation;

import java.io.File;

public class FileValidation {

    public static void saveDirectoryExists() {
        File folder = new File("C:/savedata");
        if (!folder.exists())
            folder.mkdir();
    }

    public static boolean existSaveFile() {
        File folder = new File("./savedata/save.bin");
        if (folder.exists()) {
            return true;
        }
        return false;
    }

    public static boolean existSaveToContinue() {
        File folder = new File("./savedata/save.bin");
        if (folder.exists()) {
            return true;
        }
        return false;
    }
}
