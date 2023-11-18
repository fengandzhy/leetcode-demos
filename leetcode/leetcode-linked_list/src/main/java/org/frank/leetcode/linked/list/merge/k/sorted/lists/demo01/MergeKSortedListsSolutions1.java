package org.frank.leetcode.linked.list.merge.k.sorted.lists.demo01;

import org.frank.leetcode.linked.list.merge.k.sorted.lists.ListNode;

import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 * */
public class MergeKSortedListsSolutions1 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode headerNode = new ListNode();
        ListNode currentNode = headerNode;
        List<ListNode> tempList = new ArrayList<>();
        for(ListNode node:lists){
            if(node != null){
                tempList.add(node);
            }            
        }
        if(tempList!=null && tempList.size() > 0){
            tempList.sort((a,b) ->{
                return a.val - b.val;
            });
            merge(currentNode,tempList);
        }        
        return headerNode.next;
    }
    
    private void merge(ListNode currentNode, List<ListNode> tempList){
        currentNode.next = tempList.get(0);
        currentNode = currentNode.next;
        ListNode newNode = tempList.get(0).next;
        tempList.remove(0);
        if(newNode != null){
            tempList.add(newNode);
            tempList.sort((a,b) ->{
                return a.val - b.val;
            });
        }
        if(tempList!=null && tempList.size() > 0){
            merge(currentNode,tempList);
        }             
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);

    }
}
