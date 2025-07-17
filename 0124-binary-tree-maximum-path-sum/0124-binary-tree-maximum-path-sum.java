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
    public int maxPathSum(TreeNode root) {
        int []maxSum=new int[1];
        maxSum[0]=Integer.MIN_VALUE;
        maxPathDown(root,maxSum);
        return maxSum[0];
    }
        private int maxPathDown(TreeNode node, int maxSum[]){
            if(node==null) return 0;
            int leftSum=maxPathDown(node.left,maxSum);
            if (leftSum<0) leftSum=0;
            int rightSum=maxPathDown(node.right,maxSum);
            if (rightSum<0) rightSum=0;

            maxSum[0]=Math.max(maxSum[0],node.val+leftSum+rightSum);
            return node.val+Math.max(leftSum,rightSum);
        }
    
}