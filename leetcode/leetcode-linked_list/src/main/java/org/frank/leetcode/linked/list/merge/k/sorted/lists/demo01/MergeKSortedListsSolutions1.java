package org.frank.leetcode.linked.list.merge.k.sorted.lists.demo01;

import org.frank.leetcode.linked.list.merge.k.sorted.lists.ListNode;

import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 * */
public class MergeKSortedListsSolutions1 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode headerNode = new ListNode(); // 先确保有一个头节点, 这个头节点并不是真正的头节点，而是返回的队列里头节点的上一个节点
        ListNode currentNode = headerNode;  // 这个是遍历节点
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
        currentNode.next = tempList.get(0); // 升序排好的数组, 每次都取第一位
        currentNode = currentNode.next;
        ListNode newNode = tempList.get(0).next;
        tempList.remove(0);
        if(newNode != null){
            tempList.add(newNode);
            tempList.sort((a,b) ->{ // 加入新节点之后重新排序
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
