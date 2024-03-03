package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class PalindromePairs {
    public static void main(String[] args) {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(palindromePairs(words));
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);
                if (isPalindrome(left)) {
                    String reverseRight = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(reverseRight) && map.get(reverseRight) != i) {
                        result.add(Arrays.asList(map.get(reverseRight), i));
                    }
                }
                if (isPalindrome(right) && right.length() != 0) {
                    String reverseLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(reverseLeft) && map.get(reverseLeft) != i) {
                        result.add(Arrays.asList(i, map.get(reverseLeft)));
                    }
                }
            }
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
