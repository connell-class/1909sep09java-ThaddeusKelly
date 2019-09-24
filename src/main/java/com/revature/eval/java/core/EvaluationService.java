package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.*;

public class EvaluationService {
	
	//Finished: 1, 2, 3, 4, 5, 7, 8, 9, 10, 12, 18

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 */
	//TODO not sure what happened to the question, but done
	public String acronym(String phrase) {
		phrase = phrase.toUpperCase();
		boolean space = false;
		StringBuilder acronym = new StringBuilder("");
		acronym.append(phrase.charAt(0));
		for (int i = 0; i < phrase.length(); i++) {
			if(space == true && Character.isLetter(phrase.charAt(i))) {
				acronym.append(phrase.charAt(i));
				space = false;
				continue;
			}
			if (phrase.charAt(i) == ' ' || phrase.charAt(i) == '-') {
				space = true;
				continue;
			}
		}
		return new String(acronym);
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		//TODO Done
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (sideOne == sideTwo && sideOne == sideThree)
				return true;
			else
				return false;
		}

		public boolean isIsosceles() {
			if (sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree)
				return true;
			else
				return false;
		}

		public boolean isScalene() {
			if (sideOne != sideTwo && sideOne != sideThree)
				return true;
			else
				return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		//TODO Done
		string = string.toUpperCase();
		int score = 0;
		int i;
		for (i = 0; i < string.length(); i++) {
			switch (string.charAt(i)) {
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'L':
			case 'N':
			case 'R':
			case 'S':
			case 'T':
				score = score + 1;
				break;
			case 'D':
			case 'G':
				score = score + 2;
				break;
			case 'B':
			case 'C':
			case 'M':
			case 'P':
				score = score + 3;
				break;
			case 'F':
			case 'H':
			case 'V':
			case 'W':
			case 'Y':
				score = score + 4;
				break;
			case 'K':
				score = score + 5;
				break;
			case 'J':
			case 'X':
				score = score + 8;
				break;
			case 'Q':
			case 'Z':
				score = score + 10;
				break;
			default:
				break;
			}
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		//TODO done
		boolean countryCodeSearch = false;
		char[] number = new char[10];
		int numLoc = 0;

		for (int i = 0; i < string.length(); i++) {
			if(Character.isLetter(string.charAt(i))) {
				throw new IllegalArgumentException("Non-numeric Characters");
			}
			switch (string.charAt(i)) {
			case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0': {
				if (countryCodeSearch == false & string.charAt(i) == '1') {
				}
				else {
					if (numLoc == 10)
						throw new IllegalArgumentException("Too many numbers");
					number[numLoc] = string.charAt(i);
					numLoc++;
				}
				countryCodeSearch = true;
				break;
			}
			default:
				break;
			}
		}
		StringBuilder builder = new StringBuilder("");
		for(int j = 0; j < number.length; j++) {
			builder.append(number[j]);
		}
		String toReturn = new String(builder);
		return toReturn;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		boolean space = true;
		int wordStart = 0;
		int wordEnd = 0;
		Map<String, Integer> counter = new HashMap<>();
		for(int j = 0; j<string.length(); j++) {
			if(Character.isLetter(string.charAt(j)) && space == true) {
				wordStart = j;
				space = false;
				System.out.println(wordStart);
			}
			else if((j == string.length() - 1 && string.charAt(j)!=' ') || string.charAt(j+1)==' ') {
				space = true;
				wordEnd = j+1;
					//TODO if that key is not already in counter:
				counter.put(string.substring(wordStart, wordEnd), 1);
			}
		}
		return null;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO DONE
			if(!sortedList.contains(t)) {
				throw new IllegalArgumentException("Item not found");
			}
			int counter = sortedList.size()/2;
			int half = counter;
			boolean found = false;
			do {
				System.out.println(t);
				System.out.println(sortedList.get(counter));
				if(t.equals(sortedList.get(counter))){
					System.out.println("found");
					found = true;
					break;
				}
				else {
					half = half/2;
					if((int)t < (int)sortedList.get(counter)) {
						if(half == 0)
							counter--;
						else
							counter = counter-half;
					}
					else if((int)t > (int)sortedList.get(counter)) {
						if(half == 0)
							counter++;
						else
							counter = counter + half;
					}
				}
			}while(!found);
			return counter;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	/**
	 * @param input
	 * @return
	 */
	public String toPigLatin(String input) {
		input = input.toLowerCase();
		boolean space = true;
		int wordStart = 0;
		int wordEnd = 0;
		StringBuilder toOutput = new StringBuilder("");
		StringBuilder string = new StringBuilder("");
		//TODO DONE
		for(int j = 0; j<input.length(); j++) {
			if(Character.isLetter(input.charAt(j)) && space == true) {
				wordStart = j;
				space = false;
				System.out.println(wordStart);
			}
			else if((j == input.length() - 1 && input.charAt(j)!=' ') || input.charAt(j+1)==' ') {
				space = true;
				wordEnd = j+1;
				System.out.println(wordEnd);
				string.delete(0, string.length());
				string.append(input.substring(wordStart, wordEnd));
				string.setLength(wordEnd-wordStart);
				String copy = new String(string.toString());
				System.out.println(string.length());
				if (string.charAt(0) == 'a' || string.charAt(0) == 'e' || string.charAt(0) == 'i' || string.charAt(0) == 'o'
						|| string.charAt(0) == 'u') {
					toOutput.append(string + "ay");
				}
				else if(string.charAt(1) == 'h' || (string.charAt(0) == 'q' && string.charAt(1) == 'u')) {
					string.setCharAt(string.length()-2, copy.charAt(0));
					string.setCharAt(string.length()-1, copy.charAt(1));
					for (int i = 2, l = 0; i < string.length(); i++, l++) {
						string.setCharAt(l, copy.charAt(i));
					}
					toOutput.append(new String(string) + "ay");
				}
				else if(string.charAt(0) == 's' && string.charAt(1) == 'c' && string.charAt(2) == 'h') {
					string.setCharAt(string.length()-3, copy.charAt(0));
					string.setCharAt(string.length()-2, copy.charAt(1));
					string.setCharAt(string.length()-1, copy.charAt(2));
					for (int i = 3, m = 0; i < string.length(); i++, m++) {
						string.setCharAt(m, copy.charAt(i));
					}
					toOutput.append(new String(string) + "ay");
				}
				else {
					for (int i = 1, k = 0; i < string.length(); i++, k++) {
						string.setCharAt(k, copy.charAt(i));
						string.setCharAt(string.length()-1, copy.charAt(0));
					}
					toOutput.append(new String(string) + "ay");
				}
				if(j!=input.length()-1) {
					toOutput.append(" ");
				}
			}
		}
		return new String(toOutput);
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		//TODO done
		String number = new String(Integer.toString(input));
		double finalNumber = 0;
		for(int a = 0; a<number.length(); a++) {
			finalNumber += Math.pow(Character.getNumericValue(number.charAt(a)), number.length());
		}
		if(finalNumber==input)
			return true;
		else
			return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	//TODO done
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> list = new ArrayList<>();
		boolean finish = false;
		int counter = 1;
		long prime = 0L;
		while(!finish) {
			prime = (long) calculateNthPrime(counter);
			if(l%prime==0 && l!=prime) {
				counter = 0;
				list.add(prime);
				l /= prime;
			}
			if(l == prime) {
				list.add(l);
				finish = true;
			}
			counter++;
		}
		return list;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			String input = string.toLowerCase();
			char[] translated = new char[string.length()];
			HashMap<Integer, Character> hm = new HashMap<>();
			HashMap<Character, Integer> alphabet = new HashMap<>();
			int letterKey = 0;
			int translator = 0;
			// storage for translating the input
			hm.put(1, 'a');
			hm.put(2, 'b');
			hm.put(3, 'c');
			hm.put(4, 'd');
			hm.put(5, 'e');
			hm.put(6, 'f');
			hm.put(7, 'g');
			hm.put(8, 'h');
			hm.put(9, 'i');
			hm.put(10, 'j');
			hm.put(11, 'k');
			hm.put(12, 'l');
			hm.put(13, 'm');
			hm.put(14, 'n');
			hm.put(15, 'o');
			hm.put(16, 'p');
			hm.put(17, 'q');
			hm.put(18, 'r');
			hm.put(19, 's');
			hm.put(20, 't');
			hm.put(21, 'u');
			hm.put(22, 'v');
			hm.put(23, 'w');
			hm.put(24, 'x');
			hm.put(25, 'y');
			hm.put(26, 'z');
			for (int u = 1; u <= 26; u++) {
				alphabet.put(hm.get(u), u);
			}
			// creates a reversed reference of hm. I just didn't feel like typing all of
			// those .puts backwards
			for (int i = 1; i < 26; i++) {
				if (i - key <= 0) {
					letterKey = i - key + 26;
				} else {
					letterKey = i - key;
				}
				hm.replace(letterKey, hm.get(i));
				System.out.println(hm.get(i));
			}
			hm.replace(key, 'z');
			for (int j = 0; j < string.length(); j++) {
				if(Character.isAlphabetic(input.charAt(j))){
					translator = alphabet.get(input.charAt(j));
					translated[j] = hm.get(translator);
				}
				else
					translated[j] = input.charAt(j);
			}
			for(int z=0; z<string.length(); z++) {
				if(Character.isUpperCase(string.charAt(z))) {
					translated[z]=Character.toUpperCase(translated[z]);
				}
			}
			//TODO WHY IS THIS BREAKING?!
			return new String(translated);
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		//TODO done
		if (i<=0) {
			throw new IllegalArgumentException("Number must be greater than 0");
		}
		int number = 0;
		int counter = 0;
		boolean isPrime = false;
		do {
			number++;
			for(int divider = 2; divider<=number; divider++) {
				if(number%divider==0 && number!=divider) {
					break;
				}
				else if(divider == number) {
					isPrime=true;
				}
			}
			if(isPrime) {
				counter++;
				isPrime=false;
			}
		}while(counter != i);
		return number;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			string = string.toLowerCase();
			HashMap<Character, Integer> alphabet = new HashMap<>();
			HashMap<Integer, Character> hm = new HashMap<>();
			hm.put(1, 'a');
			hm.put(2, 'b');
			hm.put(3, 'c');
			hm.put(4, 'd');
			hm.put(5, 'e');
			hm.put(6, 'f');
			hm.put(7, 'g');
			hm.put(8, 'h');
			hm.put(9, 'i');
			hm.put(10, 'j');
			hm.put(11, 'k');
			hm.put(12, 'l');
			hm.put(13, 'm');
			hm.put(14, 'n');
			hm.put(15, 'o');
			hm.put(16, 'p');
			hm.put(17, 'q');
			hm.put(18, 'r');
			hm.put(19, 's');
			hm.put(20, 't');
			hm.put(21, 'u');
			hm.put(22, 'v');
			hm.put(23, 'w');
			hm.put(24, 'x');
			hm.put(25, 'y');
			hm.put(26, 'z');
			for (int u = 1; u <= 26; u++) {
				alphabet.put(hm.get(u), u);
			}
			char[] translated = new char[string.length()];
			for (int i = 0; i < string.length(); i++) {
				if (alphabet.get(string.charAt(i)) <= 13) {
					// below M: doubles the difference and adds it to the letter's value
					translated[i] = hm
							.get(alphabet.get(string.charAt(i)) + ((14 - alphabet.get(string.charAt(i))) * 2));
				} else if (alphabet.get(string.charAt(i)) >= 14) {
					// over N: doubles the difference and subtracts it from the letter's value
					translated[i] = hm
							.get(alphabet.get(string.charAt(i)) - ((alphabet.get(string.charAt(i)) - 13) * 2));
				} else {
					// everything else: leaves it be
					translated[i] = string.charAt(i);
				}
				// TODO it still needs to remove spaces and other symbols right?
				// Guess it needs to be a list instead of an array
			}
			return new String(translated);
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String end = new String(encode(string));
			return end;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		List<Integer> numbers = new LinkedList<>();
		int sum = 0;
		// add all numbers to the list
		for (int i = 0; i < string.length(); i++) {
			switch (string.charAt(i)) {
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case '0':
				numbers.add(Character.getNumericValue(string.charAt(i)));
				break;
			case 'X':
				numbers.add(10);
				break;
			default:
				break;
			}
		}
		// check to make sure there are the right amount of numbers
		if (numbers.size() != 10)
			return false;
		// otherwise, do the equation
		for (int j = 0; j < numbers.size(); j++) {
			sum = sum + (numbers.get(j) * j);
		}
		if (sum % 10 == 0)
			return true;
		else
			return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: pan gramma,
	 * "every letter") is a sentence using every letter of the alphabet at least
	 * once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		int sum = 0;
		boolean max = false;
		int b = 1;
		List<Integer> used = new ArrayList<>(); 
		for(int a : set) {
			do {
				max = false;
				if(a*b<i && !used.contains(a*b)) {
					sum+=a*b;
					used.add(a*b);
					System.out.println(a + ", "+ b + ", " + sum);
				}
				else if(a*b>=i) {
					b = 1;
					max=true;
					break;
				}
				b++;
			}while(!max);
		}
		//TODO DONE
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		//list required
		int finalValue = 0;
		int counter = 0;
		List<Character> nextString = new ArrayList<>();
		for(int i = 0; i < string.length();) {
			if(string.charAt(i)!=' ') {
				nextString.add(string.charAt(i));
			}
		}
		for(char z:nextString) {
			if((counter+1)%2==0) {
				finalValue += 2*(Integer.valueOf(z));
			}
			else {
				finalValue += (Integer.valueOf(z));
			}
			counter++;
		}
		if(finalValue % 10 == 0)
			return true;
		else
			return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13? 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5? 2
	 * 
	 * What is 6 multiplied by 4? 24
	 * 
	 * What is 25 divided by 5? 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO number start and number end not ending up in the right places
		int num1 = 0;
		int num2 = 0;
		boolean isNumber = false;
		int numberStart = 0;
		int numberEnd = 0;
		for(int i = 0; i < string.length(); i++) {
			if(Character.isDigit(string.charAt(i)) || string.charAt(i) == '-') {
				numberStart=i;
				isNumber = true;
				System.out.println(string.charAt(i));
			}
			if((string.charAt(i)==' ' || string.charAt(i)=='?') && isNumber == true) {
				numberEnd=i;
				isNumber = false;
				if(num1!=0) {
					num2=Integer.valueOf(string.substring(numberStart, numberEnd));
				}
				else {
					num1=Integer.valueOf(string.substring(numberStart, numberEnd));
				}
			}
		}
		if(string.contains(" add ") || string.contains(" plus ")) {
			return num1 + num2;
		}
		else if(string.contains(" minus ") || string.contains(" subtracted ")) {
			return num1 - num2;
		}
		else if(string.contains(" multiplied ")) {
			return num1 * num2;
		}
		else if(string.contains(" divided ")) {
			return num1 / num2;
		}
		else
			return 0;
	}

}
