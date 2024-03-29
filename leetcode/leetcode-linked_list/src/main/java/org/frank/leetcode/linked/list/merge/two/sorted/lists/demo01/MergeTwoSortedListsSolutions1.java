package org.frank.leetcode.linked.list.merge.two.sorted.lists.demo01;

import org.frank.leetcode.linked.list.merge.two.sorted.lists.ListNode;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 * 
 * */
public class MergeTwoSortedListsSolutions1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode heardNode = null;
        ListNode currentNode = null;
        while(true){                        
            if(list1 == null && list2 == null){
                break;
            }
            if(list2 == null){
                if(currentNode == null){
                    heardNode = list1;                    
                }else{
                    currentNode.next = list1;
                }                
                break;
            }
            if(list1 == null){
                if(currentNode == null){
                    heardNode = list2;
                }else{
                    currentNode.next = list2;
                }                
                break;
            }
            if(list1.val < list2.val){
                if(currentNode == null){
                    currentNode = list1;
                    heardNode = list1;
                    list1 = list1.next;
                    continue;
                }
                currentNode.next = list1;
                list1 = list1.next;
            }else {
                if(currentNode == null){
                    currentNode = list2; 
                    heardNode = list2;
                    list2 = list2.next;
                    continue;
                }
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }        
        return heardNode;
    }    
}
