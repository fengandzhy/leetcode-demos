package org.frank.leetcode.linked.list.merge.two.sorted.lists.demo01;

public class MergeTwoSortedListsSolutions1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        if(list2 == null){
            return list1;
        }
        if(list1 == null){
            return list2;
        }        
        while(true){
            
            if(list1 == null && list2 == null){
                break;
            }
        }
        return null;
    }
}
