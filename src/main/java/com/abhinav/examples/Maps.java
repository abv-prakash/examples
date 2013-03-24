package com.abhinav.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Maps
{

    private static Map<Integer, String> dcMap;
    static
    {
        Map<Integer, String> aMap = new HashMap<Integer, String>();
        aMap.put(1, "one");
        aMap.put(2, "two");
        dcMap = Collections.unmodifiableMap(aMap);

    }

    public static <E> Map<E, Integer> freqCompute(final ArrayList<E> list)
    {

        Map<E, Integer> freqMap = new LinkedHashMap<E, Integer>();

        for (int i = 0; i < list.size(); i++)
        {
            Integer freq = freqMap.get(list.get(i));

            freq = (freq == null) ? 1 : freq + 1;
            freqMap.put(list.get(i), freq);

        }

        return freqMap;

    }

    public static <K, V> boolean validateAttrMap(final Map<K, V> attrMap, final List<K> reqAttr, final List<K> permAttr)
    {

        if (!permAttr.containsAll(reqAttr))
        {
            System.out.println("Error: Permissible attributes does not include required Attributes");
            return false;
        }

        if (!attrMap.keySet().containsAll(reqAttr))
        {
            reqAttr.removeAll(attrMap.keySet());
            System.out.println("Error: Missing Arributes - " + reqAttr);
            return false;

        }

        if (!permAttr.containsAll(attrMap.keySet()))
        {
            attrMap.keySet().removeAll(permAttr);
            System.out.println("Error: Attributes in Map are not Permissible  Attributes : Illegal Attributes -"
                    + attrMap.keySet());

            return false;

        }
        return true;
    }

    public static void printAnagrams(final List<String> words, final int maxWordLength)
    {

        Map<String, List<String>> m = new HashMap<String, List<String>>();

        for (String word : words)
        {

            String alpha = alphabetize(word);
            List<String> alpha_anagrams = m.get(alpha);
            if (alpha_anagrams == null)
            {
                m.put(alpha, alpha_anagrams = new ArrayList<String>());

            }
            alpha_anagrams.add(word);

        }

        for (List<String> l : m.values())
        {
            if (l.size() >= maxWordLength)
            {
                System.out.println(l.size() + ":" + l);
            }

        }

    }

    public static String alphabetize(final String word)
    {
        char[] a = word.toCharArray();
        Arrays.sort(a);
        return new String(a);

    }

    public static void main(final String[] args)
    {

        ArrayList<String> list = new ArrayList<String>(Arrays.asList("hi", "bye", "hi", "hello", "bye", "bye", "shy"));

        Map<String, Integer> freqMap = freqCompute(list);

        System.out.println("freqMap is :" + freqMap.toString());

        List<String> reqAttr = new ArrayList<String>(Arrays.asList("hi", "hello"));
        List<String> permAttr = new ArrayList<String>(Arrays.asList("hi", "hello", "bye"));

        System.out.println(validateAttrMap(freqMap, reqAttr, permAttr));
        System.out.println("dcMap:" + dcMap);

    }

}