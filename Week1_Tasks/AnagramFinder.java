import java.util.*;

public class AnagramFinder {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pCount = new int[26], sCount = new int[26];

        for (char c : p.toCharArray()) pCount[c - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            if (i >= p.length()) sCount[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(pCount, sCount)) result.add(i - p.length() + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}