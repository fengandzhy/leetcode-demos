package org.frank.leetcode.linked.list.linked.list.cycle.demo01;

import org.frank.leetcode.linked.list.linked.list.cycle.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 * */
public class LinkedListCycleSolution1 {
    public boolean hasCycle(ListNode head) {
        boolean isCycle = false;
        if(head == null){
            return false;
        }
        ListNode node = head;
        List<ListNode> nodeList = new ArrayList<>();
        nodeList.add(node);
        while(true){
            node = node.next;
            if(node == null){
                break;
            }
            if(nodeList.contains(node)){
                isCycle = true;
                break;
            }
            nodeList.add(node);
        }
        return isCycle;
    }
}
