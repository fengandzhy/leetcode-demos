package org.frank.leetcode.string.reverse.linked.list.demo01;

import org.frank.leetcode.string.reverse.linked.list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/reverse-linked-list/description/
 * */
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
}
