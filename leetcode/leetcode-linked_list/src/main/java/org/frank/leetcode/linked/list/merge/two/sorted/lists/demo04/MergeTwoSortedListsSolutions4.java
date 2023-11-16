package org.frank.leetcode.linked.list.merge.two.sorted.lists.demo04;

import org.frank.leetcode.linked.list.merge.two.sorted.lists.ListNode;
import org.frank.leetcode.linked.list.merge.two.sorted.lists.demo01.MergeTwoSortedListsSolutions1;

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
            }else if(list2 == null){
                nodes.add(list1);
                list1 = list1.next;
            }else if(list1.val < list2.val){ // 必须注意这里要用 else if 
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

    public static void main(String[] args) {
        MergeTwoSortedListsSolutions4 solutions4 = new MergeTwoSortedListsSolutions4();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        solutions4.mergeTwoLists(node1,node4);
    }
}
