/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return calcHtDiff(root) !=-1;
    }
    public int calcHtDiff(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftHt= calcHtDiff(node.left);
        if(leftHt==-1) return -1;
        int rightHt= calcHtDiff(node.right);
        if(rightHt==-1) return -1;

        if(Math.abs(leftHt-rightHt)>1) return -1;

        return Math.max(leftHt,rightHt)+1;
    }
}