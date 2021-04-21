package model.entities;

import java.util.ArrayList;
import java.util.List;

public class ReverseShuffler implements Shuffler {

	@Override
	public String shuffle(String s) {
		List<String> letters = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			letters.add(String.valueOf(s.charAt(s.length() - (i+1))));
		}

		StringBuilder t = new StringBuilder(s.length());
		for (String k : letters) {
			t.append(k);
		}
		return t.toString();
	}
}
