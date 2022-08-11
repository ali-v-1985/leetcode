package me.valizadeh.practices.leetcode.leetcode0005;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
    }
    public String longestPalindrome(String s) {
        int maxPalSize = 0;
        String lp = "";
        for(int i = 0; i < s.length(); i++) {
            String oddPal = longestPalindrome(s, i, i);
            String evenPal = longestPalindrome(s, i, i + 1);
            if(oddPal.length()> evenPal.length()) {
                if(maxPalSize < oddPal.length()) {
                    maxPalSize = oddPal.length();
                    lp = oddPal;
                }
            } else {
                if(maxPalSize < evenPal.length()) {
                    maxPalSize = evenPal.length();
                    lp = evenPal;
                }
            }

        }
        return lp;
    }

    private String longestPalindrome(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(++l, r);
    }
}
