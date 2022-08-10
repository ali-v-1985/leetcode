package me.valizadeh.practices.leetcode.leetcode0004;

import java.util.stream.IntStream;

class Solution {

    public static void main(String[] args) {
        BFSol s = new BFSol();
        System.out.println("BFSol [1,2], [3, 4] : " + s.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        EfficientSol e = new EfficientSol();
        System.out.println("EfficientSol [1,2], [3, 4] : " + e.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println("EfficientSol [0,0], [0, 0] : " + e.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println("EfficientSol [1,3], [2] : " + e.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        int[] bigArray1 = new int[2000000];
        int[] bigArray2 = new int[2000000];
        IntStream.range(0, 2000000).forEach(i-> {
            bigArray1[i] = i - 1000000 ;
            bigArray2[i] = i - 1000000;
        });
        long bfStart = System.nanoTime();
        System.out.println("BFSol BigArrays : " + s.findMedianSortedArrays(bigArray1, bigArray2));
        long bfEnd = System.nanoTime();
        System.out.println("BFSol took : " + (bfEnd - bfStart)/ 1000000.0);
        long eStart = System.nanoTime();
        System.out.println("EfficientSol BigArrays : " + e.findMedianSortedArrays(bigArray1, bigArray2));
        long eEnd = System.nanoTime();
        System.out.println("EfficientSol took : " + (eEnd - eStart) / 1000000.0);

    }

    static class BFSol {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) { // time O(n+m) space O(n+m)
            int[] merged = new int[nums1.length + nums2.length];
            int nums1Indx = 0;
            int nums2Indx = 0;
            for (int i = 0; i < merged.length; i++) {
                if (nums1Indx < nums1.length && nums2Indx < nums2.length) {
                    if (nums1[nums1Indx] < nums2[nums2Indx]) {
                        merged[i] = nums1[nums1Indx++];
                    } else {
                        merged[i] = nums2[nums2Indx++];
                    }
                } else {
                    if (nums1Indx < nums1.length) {
                        merged[i] = nums1[nums1Indx++];
                    } else if (nums2Indx < nums2.length) {
                        merged[i] = nums2[nums2Indx++];
                    }
                }
            }
            int centerIndx = merged.length / 2;
            int centerDeviation = merged.length % 2;
            if (centerDeviation == 0) {
                return (merged[centerIndx - 1] + merged[centerIndx]) / 2.0;
            } else {
                return merged[centerIndx] * 1.0;
            }

        }
    }

    //    https://www.youtube.com/watch?v=q6IEA26hvXc
    static class EfficientSol {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) { // time O(log(n+m)) space O(1)
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }
            int total = nums1.length + nums2.length;
            int half = total / 2;
            int l = 0;
            int r = nums1.length - 1;
            while (true) {
                int lr = l + r;
                int i;
                if (lr < 0) {
                    i = (int) Math.floor(lr / 2.0);
                } else {
                    i = lr / 2;
                }
                int j = half - i - 2;
                int smallerLeft = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
                int smallerRight = i + 1 < nums1.length ? nums1[i + 1] : Integer.MAX_VALUE;

                int biggerLeft = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
                int biggerRight = j + 1 < nums2.length ? nums2[j + 1] : Integer.MAX_VALUE;

                if (smallerLeft <= biggerRight && biggerLeft <= smallerRight) {
                    if (total % 2 == 0) {
                        return (Integer.max(smallerLeft, biggerLeft) + Integer.min(smallerRight, biggerRight)) / 2.0;
                    } else {
                        return Integer.min(smallerRight, biggerRight);
                    }
                } else if (smallerLeft > biggerRight) {
                    r = i - 1;
                } else {
                    l = i + 1;
                }
            }
        }
    }
}