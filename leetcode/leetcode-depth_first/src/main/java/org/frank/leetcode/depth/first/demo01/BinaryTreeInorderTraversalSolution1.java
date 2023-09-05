package org.frank.leetcode.depth.first.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * 所谓中序遍历就是先左节点, 再中间节点, 再右节点
 *  
 * */
public class BinaryTreeInorderTraversalSolution1 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getValue(root, list);
        return list;
    }
    
    public void getValue(TreeNode node, List<Integer> list){
        if(node != null){
            if(node.left != null){
                getValue(node.left, list);
            }
            list.add(node.val);
            if(node.right != null){
                getValue(node.right, list);
            }           
        }        
    }
}
