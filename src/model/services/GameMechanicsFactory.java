package model.services;

import game.PointMechanics;
import game.TriesMechanics;

public class GameMechanicsFactory {

	public static PointMechanics instantiatePointMechanics() {
		return new PointMechanics();
	}	
	
	public static TriesMechanics instantiateTriesMechanics() {
		return new TriesMechanics();
	}	
}