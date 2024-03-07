package org.frank.leetcode.string.reverse.linked.list.demo02;

import org.frank.leetcode.string.reverse.linked.list.ListNode;

public class ReverseLinkedListSolution2 {
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode currentNode = head;
        while(currentNode != null){
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }
}
