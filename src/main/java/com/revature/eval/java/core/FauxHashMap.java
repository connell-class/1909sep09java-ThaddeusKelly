package com.revature.eval.java.core;

public class FauxHashMap {
	// This only works for two integers. For other arguments, new methods must be
	// created to overload this one
	//Array Extender not working
	private int[] K = new int[10]; // Keys
	private int[] E = new int[10]; // Elements
	private int size = 0; // Size of the HashMap (used for some calculations)
	
	//constructor
	FauxHashMap(){
		//Constructor builder
	}

	// gets all elements based on a key
	public int get(int i) {
		int toReturn = 0;
		boolean checker = false;
		// checks for the existence of a key within the array
		for (int j = 0; j < K.length; j++) {
			if (K[j] == i) {
				toReturn = E[j];
				checker = true;
			}
			if (checker==true)
				break;
		}
		if (checker == true)
			return toReturn;
		else
			throw new IllegalArgumentException("Key not found");
	}

	// adds a key/element
	public void put(int i, int j) {
		// check for existing key. If the key already exists, an exception is thrown
		for (int k = 0; k < K.length; k++) {
			if (i == K[k]) {
				throw new IllegalArgumentException("Key already in use");
			}
		}
		// increase array sizes as necessary
//		arrayLengthener(K);
//		arrayLengthener(E);
		// add elements
		K[size] = i;
		E[size] = j;
		size = size + 1;
	}

	//lengthens arrays by 1 element without removing the variables contained within
	//This would be great to put into an Interface for later projects
	//TODO not working, check in on it later
	public int[] arrayLengthener(int[] toReturn) {
		// creates keeper to store variables while toReturn is being lengthened
		int[] keeper = new int[toReturn.length];
		keeper = toReturn;
		// Lengthen by 1 element
		toReturn = new int[toReturn.length + 1];
		// returns values to their proper place
		for (int k = 0; k < keeper.length; k++) {
			toReturn[k] = keeper[k];
		}
		return toReturn;
	}
}