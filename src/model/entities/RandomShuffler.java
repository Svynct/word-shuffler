package model.entities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomShuffler implements Shuffler {

	@Override
	public String shuffle(String s) {
	    List<String> letters = Arrays.asList(s.split(""));
	    Collections.shuffle(letters);
	    StringBuilder t = new StringBuilder(s.length());
	    for (String k : letters) {
	        t.append(k);
	    }
	    return t.toString();
	}
}
