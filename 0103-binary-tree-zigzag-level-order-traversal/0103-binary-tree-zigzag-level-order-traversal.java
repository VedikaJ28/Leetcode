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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        Queue<TreeNode> check = new LinkedList<>();
        if(root==null) return result;
        check.offer(root);
        int j=0;
        while(!check.isEmpty()){
            int levelsize= check.size();
            List<Integer> res=new ArrayList<>();
            j++;
            for(int i=0;i<levelsize;i++){
                if(check.peek().left!=null) check.offer(check.peek().left);
                if(check.peek().right!=null) check.offer(check.peek().right);
                res.add(check.poll().val);
            }
            if(j%2==1){
                result.add(res);
            }
            else{
                Collections.reverse(res);
                result.add(res);
            }
        }
        return result;
    }
}