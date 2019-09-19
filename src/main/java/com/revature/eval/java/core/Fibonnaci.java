package com.revature.eval.java.core;

import java.util.Arrays;

public class Fibonnaci {
	public static void main (String[] args) {
		System.out.println(calculateRecursion(9));
		System.out.println(calculateLoop(9));
	}
	
	static int calculateRecursion(int i) {
		int number = 0;
		int j = 1;
		number = calculateRecursion(number, j, i);
		return number;
	}
	
	static int calculateRecursion(int number, int j, int i) {
		i--;
		if (i==0) {
			return number;
		}
		int holder = number;
		number = number + j;
		j = holder;
		number = calculateRecursion(number, j, i);
		return number;
	}
	
	static int calculateLoop(int i) {
		int number = 0;
		int j = 1;
		int holder = 0;
		for(int k = 1; k<i; k++) {
			holder = number;
			number = number + j;
			j = holder;
		}
		
		return number;
	}
	
	static int[] mergeSort(int[] i) {
		if (i.length == 1) {
			return i;
		}
		int[] a = Arrays.copyOfRange(i, 0, i.length/2);
		int[] b = Arrays.copyOfRange(i, (i.length/2)+1, i.length-1);
		if(a.length != 1) {
			mergeSort(a);
			mergeSort(b);
		}
		i=merge(a, b);
		return i;
	}
	
	static int[] merge(int[] a, int[] b) {
		int[] i = new int[a.length+b.length];
		
		return i;
	}
}
