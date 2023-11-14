package org.frank.leetcode.linked.list.remove.nth.node.from.end.of.lis.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 * */
public class RemoveNthNodeFromEndOfListSolution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {        
        List<ListNode> nodeList = new ArrayList<>();
        if(head == null){
            return null;
        }        
        ListNode tempNode = head;
        while(true){
            nodeList.add(tempNode);
            tempNode = tempNode.next;
            if(tempNode == null){
                break;
            }           
        }
        if(n > nodeList.size()){
            return null;
        } else {
            ListNode node =nodeList.get(nodeList.size() - n);
            if(nodeList.size() - n == 0){
                head = node.next;
            }else if (n > 1) {
                ListNode prevNode = nodeList.get(nodeList.size() - n -1);
                ListNode nextNode = nodeList.get(nodeList.size() - n +1);
                prevNode.next = nextNode;                
            }else{
                ListNode prevNode = nodeList.get(nodeList.size() - n -1);
                prevNode.next = null;
            }
            return head; 
        }        
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
        RemoveNthNodeFromEndOfListSolution1 solution1 = new RemoveNthNodeFromEndOfListSolution1();
        solution1.removeNthFromEnd(node1, 2);
    }
}
