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
    static class CustomNode{
        TreeNode root;
        int level;
        int vertical;
        public CustomNode(TreeNode node, int vertical, int level){
            this.root=node;
            this.vertical=vertical;
            this.level=level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer,List<Integer>>> map=new TreeMap<>();
        List<List<Integer>> result= new ArrayList<>();

        Queue<CustomNode> q = new LinkedList<>();
        q.offer(new CustomNode(root,0,0));

        while(!q.isEmpty()){
            CustomNode temp= q.poll();
            TreeNode curr=temp.root;

            int level=temp.level;
            int vertical= temp.vertical;

            if(!map.containsKey(vertical)) map.put(vertical, new TreeMap<>()); 
            if(!map.get(vertical).containsKey(level))  map.get(vertical).put(level,new ArrayList<>());

            map.get(vertical).get(level).add(curr.val);
            Collections.sort(map.get(vertical).get(level));

            if(curr.left!=null) q.offer(new CustomNode(curr.left,vertical-1,level+1));
            if(curr.right!=null) q.offer(new CustomNode(curr.right,vertical+1,level+1));

        }
        for(int col:map.keySet()){
                ArrayList<Integer> res=new ArrayList<>();
                for(int row:map.get(col).keySet()){
                    for(int no:map.get(col).get(row)){
                        res.add(no);                        
                    }
                }
                result.add(res);
            }
        return result;
        
    }
}