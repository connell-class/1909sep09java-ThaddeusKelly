package com.revature.eval.java.core;

import java.util.Arrays;

public class bubbleSort {
	public static void main(String[] args) {
		int[] array = {1, 67, 54, 101, 7};
		Benediction(array);
	}
	
	public static void Benediction(int[] arr){
		boolean switched = false;
		int i = 0;
		int holder = 0;
		do {
			switched = false;
			for(i=0; i<arr.length-1; i++) {
				if(arr[i]>arr[i+1]) {
					holder = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = holder;
					switched = true;
				}
			}
		}while (switched);
		
		System.out.println(Arrays.toString(arr));
	}
}
