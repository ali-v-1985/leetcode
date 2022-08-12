package me.valizadeh.practices.leetcode.leetcode0006;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convert("A", 1));
        System.out.println(s.convert("PAYPALISHIRING", 3));
        System.out.println(s.convert("PAYPALISHIRING", 4));
    }
    public String convert(String s, int numRows) {
        if(numRows <= 1) {
            return s;
        }
        int i = 0, j = 0;
        int jump = ((numRows-1) * 2);
        char[] res = new char[s.length()];
        int k = 0;
        while(i < numRows) {
            if(i != 0 && i != numRows - 1 && j > 0 && i + j - (i * 2) < s.length()) {
                res[k++] = s.charAt(i + j - (i * 2));
            }

            if(i + j < s.length()) {
                res[k++] = s.charAt(i + j);
                j += jump;
            } else {
                j = 0;
                i++;
            }

        }
        return new String(res);
    }
}