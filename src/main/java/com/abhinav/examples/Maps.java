package com.abhinav.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Maps {

	private static Map<Integer, String> dcMap;
	static {
		Map<Integer, String> aMap = new HashMap<Integer, String>();
		aMap.put(1, "one");
		aMap.put(2, "two");
		dcMap = Collections.unmodifiableMap(aMap);

	}

	public static <E> Map<E, Integer> freqCompute(final ArrayList<E> list) {

		Map<E, Integer> freqMap = new LinkedHashMap<E, Integer>();

		for (int i = 0; i < list.size(); i++) {
			Integer freq = freqMap.get(list.get(i));

			freq = (freq == null) ? 1 : freq + 1;
			freqMap.put(list.get(i), freq);

		}

		return freqMap;

	}

	public static <K, V> boolean validateAttrMap(final Map<K, V> attrMap, final List<K> reqAttr, final List<K> permAttr) {

		if (!permAttr.containsAll(reqAttr)) {
			System.out.println("Error: Permissible attributes does not include required Attributes");
			return false;
		}

		if (!attrMap.keySet().containsAll(reqAttr)) {
			reqAttr.removeAll(attrMap.keySet());
			System.out.println("Error: Missing Arributes - " + reqAttr);
			return false;

		}

		if (!permAttr.containsAll(attrMap.keySet())) {
			attrMap.keySet().removeAll(permAttr);
			System.out.println("Error: Attributes in Map are not Permissible  Attributes : Illegal Attributes -"
					+ attrMap.keySet());

			return false;

		}
		return true;
	}

	public static void printAnagrams(final List<String> words, final int maxWordLength) {

		Map<String, List<String>> m = new HashMap<String, List<String>>();

		for (String word : words) {

			String alpha = alphabetize(word);
			List<String> alpha_anagrams = m.get(alpha);
			if (alpha_anagrams == null) {
				m.put(alpha, alpha_anagrams = new ArrayList<String>());

			}
			alpha_anagrams.add(word);

		}

		for (List<String> l : m.values()) {
			if (l.size() >= maxWordLength) {
				System.out.println(l.size() + ":" + l);
			}

		}

	}

	public static String alphabetize(final String word) {
		char[] a = word.toCharArray();
		Arrays.sort(a);
		return new String(a);

	}

	public static void bigMapSplit() {

		System.out.println(System.currentTimeMillis());

		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		int total = 500093;
		int batchSize = 1000;

		for (int i = 0; i <= total; i++) {
			hashMap.put(i, "value is " + i);
		}
		System.out.println("Populated the HashMap with " + total + "keys....");
		System.out.println(System.currentTimeMillis());

		TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>(hashMap);

		int lastSplit = total % batchSize;

		System.out.println("last Split:" + lastSplit);
		int lower = 0;

		for (int j = batchSize; j < total; j += batchSize) {
			System.out.println("lower-->upper : " + lower + "--->" + (j - 1));
			SortedMap<Integer, String> subMap = sortedMap.subMap(lower, j - 1);
			lower = lower + batchSize;
			System.out.println("Created subMap size:" + subMap.size());
		}

		System.out.println("Creating last map..");
		System.out.println("lower-->upper : " + (total - lastSplit) + "--->" + total);
		SortedMap<Integer, String> subMap = sortedMap.subMap(total - lastSplit - 1, total);
		System.out.println("Created Last subMap size:" + subMap.size());

		System.out.println(System.currentTimeMillis());

		/*
		 * 412 ms for 5L keys map split 
		 */

	}

	public static void runFreqCompute() {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("hi", "bye", "hi", "hello", "bye", "bye", "shy"));

		Map<String, Integer> freqMap = freqCompute(list);

		System.out.println("freqMap is :" + freqMap.toString());

		List<String> reqAttr = new ArrayList<String>(Arrays.asList("hi", "hello"));
		List<String> permAttr = new ArrayList<String>(Arrays.asList("hi", "hello", "bye"));

		System.out.println(validateAttrMap(freqMap, reqAttr, permAttr));
		System.out.println("dcMap:" + dcMap);
	}

	public static void main(final String[] args) {
		bigMapSplit();
	}

}