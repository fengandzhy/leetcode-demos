package org.frank.leetcode.linked.list.merge.k.sorted.lists.demo01;

import org.frank.leetcode.linked.list.merge.k.sorted.lists.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        return headerNode;
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
        merge(currentNode,tempList);        
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        List<ListNode> tempList = new ArrayList<>();
        tempList.add(node1);
        tempList.add(node2);
        tempList.add(node3);

        for(ListNode node : tempList){
            System.out.println(node.val);
        } 
        
        tempList.sort((a,b) ->{
            return a.val - b.val;
        });
        
        for(ListNode node : tempList){
            System.out.println(node.val);
        }
        
        tempList.remove(0);
        System.out.println(tempList.get(0).val);
    }
}
