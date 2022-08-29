package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.google.gson.Gson;

import model.entity.Player;

public class FileManagement {
	private static final String SAVE_PATH = "./savedata/save.bin";
	private static final String DATA_PATH = "./resources/data/";

	public boolean readSaveData() {
		try {
			ObjectInputStream input;
			input = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH)));
			input.close();
			return true;
		} catch (Exception e) {
			Messages.MSG("Não foi possivel ler o arquivo de save");
			return false;
		}
	}

	public static boolean savePlayerData(Player player) throws IOException, ClassNotFoundException {
		ObjectOutputStream output;
		output = new ObjectOutputStream(new FileOutputStream(new File(SAVE_PATH)));
		output.writeObject(player);
		output.close();
		return true;
	}

	public static Player loadPlayerData() {
		try {
			ObjectInputStream input;
			input = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH)));
			Player player = (Player) input.readObject();
			input.close();
			return player;
		} catch (ClassNotFoundException e) {
			System.err.println("Houve um erro!");
		} catch (IOException e) {
			System.err.println("Houve um erro!");
		}
		return null;
	}

	public static Object readJSON(String caminho, Class name) {
		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(caminho));
			Object obj = gson.fromJson(br, name);
			if (br != null) {
				br.close();
			}
			return obj;
		} catch (FileNotFoundException fnfe) {
			System.out.println("Não foi possivel encontrar o arquivo!");
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo");
		}
		return null;
	}

	public static SpecialityArray readSpecialityFile() {
		SpecialityArray sa = (SpecialityArray) FileManagement.readJSON(DATA_PATH + "speciality.json",
				SpecialityArray.class);
		return sa;
	}

	public static EnemyArray readEnemyFile() {
		EnemyArray mob = (EnemyArray) FileManagement.readJSON(DATA_PATH + "enemy.json",
				EnemyArray.class);
		return mob;
	}

	public static SpellArray readSpellFile() {
		SpellArray spell = (SpellArray) FileManagement.readJSON(DATA_PATH + "spell.json",
				SpellArray.class);
		return spell;
	}
}
