package com.revature.eval.java.core;

public class HashMapProject {
	public static void main(String[] args){
		FauxHashMap hm = new FauxHashMap();
		hm.put(1, 19);
		hm.put(2, 67);
		hm.put(3, 67);
		hm.put(4, 197);
		hm.put(6, 75);
		
		System.out.println(Integer.toString(hm.get(4)));
		System.out.println(Integer.toString(hm.get(2)));
	}
}