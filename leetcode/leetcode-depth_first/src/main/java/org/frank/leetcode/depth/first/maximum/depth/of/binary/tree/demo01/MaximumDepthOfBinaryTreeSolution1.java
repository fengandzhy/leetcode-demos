package org.frank.leetcode.depth.first.maximum.depth.of.binary.tree.demo01;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * 二叉树的最大深度
 * */
public class MaximumDepthOfBinaryTreeSolution1 {
    
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getDepth(root)+1;       
    }

    public int getDepth(TreeNode root) {
        int leftDepth = 0;
        int rightDepth = 0;        
        if(root.left!=null){
            leftDepth = getDepth(root.left) + 1;
        }
        if(root.right != null){
            rightDepth = getDepth(root.right) + 1;
        }        
        return Math.max(leftDepth, rightDepth);
    }
}
