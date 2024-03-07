package org.frank.leetcode.string.reverse.linked.list.demo01;

import org.frank.leetcode.string.reverse.linked.list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedListSolution1 {
    public ListNode reverseList(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();
        if(head == null){
            return null;
        }
        while (true) {
            if (head == null) {
                break;
            }
            nodeList.add(head);
            head = head.next;
        }
        int size = nodeList.size();
        for(int i = 0; i<size -1; i++){
            ListNode node = nodeList.get(i);
            node.next = null;
        }        
        ListNode newHead = nodeList.get(size -1);
        int i = 1;
        while (size - i > 0){
            ListNode currentNode = nodeList.get(size - i);
            ListNode nextNode = nodeList.get(size - 1 - i);
            currentNode.next = nextNode;
            i ++;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ReverseLinkedListSolution1 solution1 = new ReverseLinkedListSolution1();
        solution1.reverseList(node1);
    }
}
