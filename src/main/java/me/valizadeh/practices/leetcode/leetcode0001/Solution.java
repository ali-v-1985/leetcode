package me.valizadeh.practices.leetcode.leetcode0001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        MapSol sol = new MapSol();
        System.out.println(Arrays.toString(sol.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
    static class BF {
        public int[] twoSum(int[] nums, int target) {

            int[] indexes = new int[2];
            for(int i = 0; i < nums.length; i++) {
                for(int j = i + 1; j < nums.length; j++) {
                    if(nums[i] + nums[j] == target) {
                        indexes[0] = i;
                        indexes[1] = j;
                        break;
                    }
                }
                if(indexes[0] != indexes[1]) {
                    break;
                }
            }
            return indexes;
        }
    }

    static class MapSol {
        public int[] twoSum(int[] nums, int target) {

            Map<Integer, Integer> neededValues = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                Integer neededValue = target - nums[i];
                if(neededValues.containsKey(neededValue)) {
                    return new int[]{neededValues.get(neededValue), i};
                }
                neededValues.put(nums[i], i);
            }
            return new int[0];
        }
    }
}
