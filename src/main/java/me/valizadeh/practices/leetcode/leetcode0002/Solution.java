package me.valizadeh.practices.leetcode.leetcode0002;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public static void main(String[] args) {
        NewSol solution = new NewSol();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    static class NewSol {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return addTwoNumbers(l1, l2, 0);

        }

        private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carryOver) {
            if (l1 == null && l2 == null) {
                if (carryOver > 0) {
                    return new ListNode(carryOver);
                } else {
                    return null;
                }
            }
            int l1Val = 0;
            ListNode l1Next = null;
            if (l1 != null) {
                l1Val = l1.val;
                l1Next = l1.next;
            }
            int l2Val = 0;
            ListNode l2Next = null;
            if (l2 != null) {
                l2Val = l2.val;
                l2Next = l2.next;
            }

            int add = l1Val + l2Val + carryOver;
            return new ListNode(add % 10,
                addTwoNumbers(l1Next, l2Next, add / 10));
        }
    }

    static class OldSol {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return addTwoNumbers(l1, l2, 0);

        }

        private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carryOver) {
            if (l1 == null && l2 == null) {
                if (carryOver > 0) {
                    return new ListNode(carryOver);
                } else {
                    return null;
                }
            }
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int val = l1Val + l2Val + carryOver;
            ListNode l1Next = l1 != null ? l1.next : null;
            ListNode l2Next = l2 != null ? l2.next : null;
            int nextCarryOver = val / 10;
            ListNode next = addTwoNumbers(l1Next, l2Next, nextCarryOver);
            return new ListNode(val % 10, next);
        }
    }
}