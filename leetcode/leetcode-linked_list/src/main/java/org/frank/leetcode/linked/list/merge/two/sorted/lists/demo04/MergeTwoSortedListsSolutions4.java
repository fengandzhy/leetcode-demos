package org.frank.leetcode.linked.list.merge.two.sorted.lists.demo04;

import org.frank.leetcode.linked.list.merge.two.sorted.lists.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedListsSolutions4 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        List<ListNode> nodes = new ArrayList<>();
        while(true){
            if(list1 == null && list2 == null){
                break;
            }
            if(list1 == null){
                nodes.add(list2);
                list2 = list2.next;
            }
            if(list2 == null){
                nodes.add(list1);
                list1 = list1.next;
            }
            if(list1.val < list2.val){
                nodes.add(list1);
                list1 = list1.next;
            }else{
                nodes.add(list2);
                list2 = list2.next;
            }
        }
        for(int i = 1; i<nodes.size();i++){
            nodes.get(i-1).next = nodes.get(i);
        }
        return nodes.get(0);
    }
}
