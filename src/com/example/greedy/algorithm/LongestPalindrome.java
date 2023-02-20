package com.example.greedy.algorithm;

import java.util.HashMap;
import java.util.Map;

/*
Task #409
Given a string s which consists of lowercase or uppercase letters,
return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome1("ccc"));
    }

    public static int longestPalindrome1(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
    
    public static int longestPalindrome2(String s) {
        Map<Character, Integer> charsWithCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charsWithCount.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        int res = 0;
        for (int v : charsWithCount.values()) {
            res += v / 2 * 2;
            if (v % 2 == 1 && res % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
