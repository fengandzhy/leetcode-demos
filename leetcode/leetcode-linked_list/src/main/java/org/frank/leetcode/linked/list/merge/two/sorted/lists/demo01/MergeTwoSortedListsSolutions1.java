package org.frank.leetcode.linked.list.merge.two.sorted.lists.demo01;

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
                currentNode = list1;
//                if(heardNode == null){
//                    heardNode = currentNode;
//                }
                break;
            }
            if(list1 == null){
                currentNode = list2;
//                if(heardNode == null){
//                   heardNode = currentNode; 
//                }
                break;
            }
            if(list1.val < list2.val){
                if(currentNode == null){
                    currentNode = list1;
                }
                ListNode tempNode = currentNode;
                currentNode = list1;
                tempNode.next = currentNode;
                list1 = list1.next;
            }else {
                if(currentNode == null){
                    currentNode = list2;
                }
                ListNode tempNode = currentNode;
                currentNode = list2;
                tempNode.next = currentNode;
                list2 = list2.next;
            }
            if(heardNode == null){
                heardNode = currentNode;
            }
        }
        if(heardNode == null){
            heardNode = currentNode;
        }
        return heardNode;
    }

    public static void main(String[] args) {
        MergeTwoSortedListsSolutions1 solutions1 = new MergeTwoSortedListsSolutions1();
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

        solutions1.mergeTwoLists(node1,node4);
        
    }
}
