package org.frank.leetcode.linked.list.merge.two.sorted.lists.demo02;

import org.frank.leetcode.linked.list.merge.two.sorted.lists.ListNode;

public class MergeTwoSortedListsSolutions2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val < list2.val){ // 如果list1 < list2 那么就拿 list1.next 跟list2 继续比
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }      
    }
}
