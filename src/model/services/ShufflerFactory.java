package model.services;

import model.entities.RandomShuffler;
import model.entities.ReverseShuffler;

public class ShufflerFactory {

	public static ReverseShuffler instantiateReverseShuffler() {
		return new ReverseShuffler();
	}	
	
	public static RandomShuffler instantiateRandomShuffler() {
		return new RandomShuffler();
	}	
}