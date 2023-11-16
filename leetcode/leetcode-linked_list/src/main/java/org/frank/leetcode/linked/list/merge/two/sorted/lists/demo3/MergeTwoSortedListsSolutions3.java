package org.frank.leetcode.linked.list.merge.two.sorted.lists.demo3;

import org.frank.leetcode.linked.list.merge.two.sorted.lists.ListNode;

public class MergeTwoSortedListsSolutions3 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode headerNode = new ListNode(-1);
        ListNode listNode = headerNode;
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        while(true){
            if(list1 == null && list2 == null){
                break;
            }
            if(list1 == null){
                listNode.next = list2;
                break;
            }
            if(list2 == null){
                listNode.next = list1;
                break;
            }
            if(list1.val < list2.val){
                listNode.next = list1;
                list1 = list1.next;                
            }else{
                listNode.next = list2;
                list2 = list2.next;                
            }
            listNode = listNode.next;
        }
        return headerNode.next;
    }
}
