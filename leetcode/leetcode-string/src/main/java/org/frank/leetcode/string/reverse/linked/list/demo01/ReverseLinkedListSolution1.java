package org.frank.leetcode.string.reverse.linked.list.demo01;

import org.frank.leetcode.string.reverse.linked.list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedListSolution1 {
    public ListNode reverseList(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();
        if (head == null) {
            return null;
        }
        while (true) {
            if (head.next == null) {
                break;
            }
            nodeList.add(head);
            head = head.next;
        }
        int size = nodeList.size();
        ListNode newHead = nodeList.get(size - 1);        
        int index = size -1;
        while(index > 0){
            ListNode tempNodeHead = nodeList.get(index);
            ListNode tempNode = nodeList.get(index-1);
            tempNodeHead.next = tempNode;
            index --;
        }
        return newHead;
    }
}
