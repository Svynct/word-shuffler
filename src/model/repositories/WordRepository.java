package model.repositories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordRepository {

	static String path = "C:\\temp\\ws-eclipse\\WordShuffler\\words.txt";
	static FileReader fr = null;
	static BufferedReader br = null;

	public static String read() {

		List<String> list = new ArrayList<>();

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String line = br.readLine();

			while (line != null) {
				list.add(line);
				line = br.readLine();
			}
			Collections.shuffle(list);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list.get(0);
	}
}