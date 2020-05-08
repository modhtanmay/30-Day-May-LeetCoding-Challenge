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
    HashMap<Integer,Integer> depth_of_node;
    HashMap<Integer,TreeNode> parent_of_node;
    public boolean isCousins(TreeNode root, int x, int y) {
        depth_of_node = new HashMap();
        parent_of_node = new HashMap();
        
        find(root,null);
        
        boolean result = (depth_of_node.get(x)==depth_of_node.get(y) && parent_of_node.get(x) != parent_of_node.get(y));
        
        return result;
    }
    
    public void find(TreeNode root, TreeNode parent){
        if(root!=null){
            if(parent!=null)
                depth_of_node.put(root.val, 1+depth_of_node.get(parent.val));
            else
                depth_of_node.put(root.val,0);
            
            parent_of_node.put(root.val,parent);
            find(root.left,root);
            find(root.right,root);
        }
    }
}
