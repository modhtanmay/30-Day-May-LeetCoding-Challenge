// In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

// Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

// We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

// Return true if and only if the nodes corresponding to the values x and y are cousins.

 
// Example 1:


// Input: root = [1,2,3,4], x = 4, y = 3
// Output: false

// Example 2:


// Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
// Output: true

// Example 3:


// Input: root = [1,2,3,null,4], x = 2, y = 3
// Output: false
 

// Note:

// The number of nodes in the tree will be between 2 and 100.
// Each node has a unique integer value from 1 to 100.

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
