package MergekSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode root = null;
        ListNode cur = null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, Comparator.comparingInt((ListNode a) -> a.val));
        for (ListNode node: lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        while (heap.size() > 0) {
            ListNode node = heap.poll();
            if (node.next != null) {
                heap.add(node.next);
            }
            if (root != null) {
                cur.next = node;
                cur = cur.next;
            } else {
                root = node;
                cur = node;
            }
            cur.next = null;
        }

        return root;
    }
}
