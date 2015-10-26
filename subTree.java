/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if (T1 == null) {
            if (T2 == null) {
                return true;
            } else {
                return false;
            }
        }
        if (T2 == null) {
            return true;
        }
        if (T1.val == T2.val) {
            if (sameTree(T1, T2)) {
                return true;
            } else {
                return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
            }
        } else {
            return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
        }
    }
    
    private boolean sameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        if (n1.val == n2.val) {
            return sameTree(n1.left, n2.left) && sameTree(n1.right, n2.right);
        }
        return false;
    }
}
