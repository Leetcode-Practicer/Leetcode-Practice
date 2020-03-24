/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }

        Map<Integer, Integer> indexMap = new HashMap<Integer,Integer>();
        int length = preorder.length;
        for(int i = 0; i < length; i ++){
            indexMap.put(inorder[i],i);
        }
        TreeNode root = reBuildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }

    public TreeNode reBuildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer,Integer> indexMap){
        if(preorderStart > preorderEnd){
            return null;
        }
        
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);

        if(preorderStart == preorderEnd){
            return root;
        }else{
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart;
            int rightNodes = inorderEnd - rootIndex;
            TreeNode left = reBuildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode right = reBuildTree(preorder, preorderStart + leftNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = left;
            root.right = right;
            return root;
        }


    }
}