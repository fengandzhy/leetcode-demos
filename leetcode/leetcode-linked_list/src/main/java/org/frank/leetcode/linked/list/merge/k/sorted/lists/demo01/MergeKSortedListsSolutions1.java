package org.frank.leetcode.linked.list.merge.k.sorted.lists.demo01;

import org.frank.leetcode.linked.list.merge.k.sorted.lists.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedListsSolutions1 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode headerNode = new ListNode();
        List<ListNode> tempList = new ArrayList<>();
        for(ListNode node:lists){
            tempList.add(node);
        }
        
        
        return headerNode;
    }
}
