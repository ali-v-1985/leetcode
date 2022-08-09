package me.valizadeh.practices.leetcode.leetcode0003;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
    }

    //Sliding Window Technic
    public int lengthOfLongestSubstring(String s) {
        Set<Character> subs = new HashSet<>();
        int start = 0;
        int index = start;
        int maxLen = 0;
        while(index < s.length()) {
            if(!subs.contains(s.charAt(index))) {
                subs.add(s.charAt(index));
                index++;
            } else {
                subs.remove(s.charAt(start));
                start++;
            }
            if(subs.size() > maxLen) {
                maxLen = subs.size();
            }
        }
        return maxLen;
    }
}
