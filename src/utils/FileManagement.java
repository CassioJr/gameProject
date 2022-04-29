package utils;

import java.io.File;

public class FileManagement {
    
	// Metodo para verificar se existe a pasta de save no disco local C
	public static void SaveDirectoryExists() {
		File folder = new File("C:/savedata");
		if (!folder.exists())
			folder.mkdir();
	}

    /*Metodo que verifica se o arquivo de save do usuario existe*/
	public static boolean existSaveFile() {
		File folder = new File("./savedata/save.bin");
		if (folder.exists()) {
			return true;
		}
		return false;
	}

    /*
	 * Metodo que verifica se o arquivo de save do usuario existe, então ele deixa
	 * visivel o botão de contiunuar o save
	 */
	public static boolean existSave() {
		File folder = new File("./savedata/save.bin");
		if (folder.exists()) {
			return true;
		}
		return false;
	}

}
