package me.valizadeh.practices.leetcode.leetcode0002;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(val);
        if (next != null) {
            sb.append(", ").append(next);
        }
        return sb.toString();
    }
}